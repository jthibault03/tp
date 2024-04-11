package seedu.voyagers.classes.billsettler;

import java.util.ArrayList;
import seedu.voyagers.classes.Profile;
import seedu.voyagers.classes.Bill;
import seedu.voyagers.utils.Currency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;


public class BillSettler {
    private static final long OFFSET = 1000000000L;
    private static Set<Long> visitedEdges;


    public static void main(String[] args) {
        ArrayList<Bill> bills = new ArrayList<>();
        Profile alice = new Profile("Alice", Currency.EUR);
        Profile bob = new Profile("Bob", Currency.EUR);
        Profile charlie = new Profile("Charlie", Currency.EUR);
        Profile david = new Profile("David", Currency.EUR);

        Bill bill1 = new Bill("bill1", alice, 110.0, Currency.EUR, new HashMap<Profile, Double>(){{
                put(bob, 40.0);
                put(charlie, 20.0);
                put(david, 40.0);
            }});

        Bill bill2 = new Bill("bill2", bob, 50.0, Currency.EUR, new HashMap<Profile, Double>(){{
                put(alice, 90.0);
                put(charlie, 10.0);
            }});

        Bill bill3 = new Bill("bill3", charlie, 60.0, Currency.EUR, new HashMap<Profile, Double>(){{
                put(alice, 20.0);
                put(bob, 80.0);
            }});

        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);

        createGraphForDebts(bills);
    }


    private static String[] getNames(ArrayList<Bill> bills){
        Set<String> names = new HashSet<>();
        for (Bill bill : bills) {
            names.add(bill.getPayer().getName());
            for (Map.Entry<Profile, Double> entry : bill.getParticipants().entrySet()) {
                names.add(entry.getKey().getName());
            }
        }
        return names.toArray(new String[0]);
    }

    /**
     * This example graph is taken from my Medium blog post.
     * Here Alice, Bob, Charlie, David, Ema, Fred and Gabe are represented by vertices from 0 to 6 respectively.
     */
    public static void createGraphForDebts(ArrayList<Bill> bills) {

        String[] person = getNames(bills);
        int n = person.length;
        //  Creating a graph with n vertices
        Dinics solver = new Dinics(n, person);
        //  Adding edges to the graph
        solver = addAllTransactions(solver, bills);

        solver.printEdges();
        System.out.println();

        System.out.println();
        System.out.println("Simplifying Debts...");
        System.out.println("--------------------");
        System.out.println();

        //  Map to keep track of visited edges
        visitedEdges = new HashSet<>();
        Integer edgePos;

        while((edgePos = getNonVisitedEdge(solver.getEdges())) != null) {
            //  Force recomputation of subsequent flows in the graph
            solver.recompute();
            //  Set source and sink in the flow graph
            Dinics.Edge firstEdge = solver.getEdges().get(edgePos);
            solver.setSource(firstEdge.from);
            solver.setSink(firstEdge.to);
            //  Initialize the residual graph to be same as the given graph
            List<Dinics.Edge>[] residualGraph = solver.getGraph();
            List<Dinics.Edge> newEdges = new ArrayList<>();

            for(List<Dinics.Edge> allEdges : residualGraph) {
                for(Dinics.Edge edge : allEdges) {
                    long remainingFlow = ((edge.flow < 0) ? edge.capacity : (edge.capacity - edge.flow));
                    //  If there is capacity remaining in the graph, then add the remaining capacity as an edge
                    //  so that it can be used for optimizing other debts within the graph
                    if(remainingFlow > 0) {
                        newEdges.add(new Dinics.Edge(edge.from, edge.to, remainingFlow));
                    }
                }
            }

            //  Get the maximum flow between the source and sink
            long maxFlow = solver.getMaxFlow();
            //  Mark the edge from source to sink as visited
            int source = solver.getSource();
            int sink = solver.getSink();
            visitedEdges.add(getHashKeyForEdge(source, sink));
            //  Create a new graph
            solver = new Dinics(n, person);
            //  Add edges having remaining capacity
            solver.addEdges(newEdges);
            //  Add an edge from source to sink in the new graph with obtained maximum flow as it's weight
            solver.addEdge(source, sink, maxFlow);
        }
        //  Print the edges in the graph
        solver.printEdges();
        System.out.println();
    }

    private static Dinics addAllTransactions(Dinics solver, ArrayList<Bill> bills) {

        HashMap<String, Integer> nameToIndex = new HashMap<>();
        String[] person = getNames(bills);
        for (int i = 0; i < person.length; i++) {
            nameToIndex.put(person[i], i);
        }


        for (Bill bill : bills) {
            Profile payer = bill.getPayer();
            HashMap <Profile, Double> participants = bill.getParticipants();

            int indexReceiver = nameToIndex.get(payer.getName());
            double amount = bill.getAmount();

            for (Map.Entry<Profile, Double> entry : participants.entrySet()) {
                Profile ower = entry.getKey();
                double owing = entry.getValue()  * amount; //in cents

                int indexOwer = nameToIndex.get(ower.getName());
                //Quantity in cents
                solver.addEdge(indexOwer, indexReceiver, (long) owing);
            }
        }

        return solver;
    }

    /**
     * Get any non visited edge in the graph
     * @param edges list of all edges in the graph
     * @return index of a non visited edge
     */
    private static Integer getNonVisitedEdge(List<Dinics.Edge> edges) {
        Integer edgePos = null;
        int curEdge = 0;
        for(Dinics.Edge edge : edges) {
            if(!visitedEdges.contains(getHashKeyForEdge(edge.from, edge.to))) {
                edgePos = curEdge;
            }
            curEdge++;
        }
        return edgePos;
    }

    /**
     * Get a unique hash key for a given edge
     * @param u the starting vertex in the edge
     * @param v the ending vertex in the edge
     * @return a unique hash key
     */
    private static Long getHashKeyForEdge(int u, int v) {
        return u * OFFSET + v;
    }
}

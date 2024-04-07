package seedu.voyagers.classes;

import seedu.voyagers.utils.Currency;
import seedu.voyagers.utils.Payable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//NOTE: this class uses object Double class, since it implements ArrayLists.

public class Bill implements Payable {

    private String billName;
    private double amount;
    private Currency currency;
    private Trip trip;
    private Profile payer;

    // hashmap with key as profile and value as the percentage of the bill they are responsible for
    // percentages must sum to 100
    private HashMap<Profile, Double> participants = new HashMap<>();

    private ArrayList<Profile> people = new ArrayList<>();
    private ArrayList<Double> percentages = new ArrayList<>();
    private boolean paid;

    public Bill(String[] args) {
        assert(args.length == 3);
        //TODO: check that the parser is splitting the args by keyword, not space.
        //TODO: change args[1] into ArrayList<Profile> people on the backend, and args[2] into ArrayList<Double>
        // percentages.
        //TODO: then call Bill(billName, newPeople, newPercentages) with this format.

    }
    public Bill(String billName, Profile payer, Double amount, Currency currency,
                ArrayList<Profile> people, ArrayList<Double> percentages) {
        if (people.size() != percentages.size()) {
            throw new IllegalArgumentException("Number of elements in 'people' and 'percentages' arrays must be equal");
        }

        checkPercentages(percentages);

        this.participants = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            this.participants.put(people.get(i), (percentages.get(i)*amount)/100.0);
        }

        this.payer = payer;
        this.amount = amount;
        this.currency = currency;

        this.billName = billName;
        this.people = people;
        this.percentages = percentages;
        this.paid = false;
    }

    //sets default percentages to equal when no percentages are provided
    public Bill(String billName, Profile payer, Double amount, Currency currency,
                ArrayList<Profile> people) {
        int numPeople = people.size();
        double percentage = (double) 100 / numPeople;
        Double[] percentages = new Double[numPeople];
        Arrays.fill(percentages, percentage);
        ArrayList<Double> p = new ArrayList<>(Arrays.asList(percentages));
        new Bill(billName, payer, amount, currency, people, p);
    }

    public Bill(String billName, Profile payer, Double amount, Currency currency,
                HashMap<Profile, Double> participants) {
        this.billName = billName;
        this.payer = payer;
        this.amount = amount;
        this.currency = currency;
        this.participants = participants;
        this.paid = false;
    }

    public Bill(String billName) {
        this.billName = billName;
        this.paid = false;
    }


    //Right now, just concerns people within this Bill. Future goal: update to entire trip.
    public void addPeople(Profile[] newPeople) {
        for (Profile newPerson : newPeople) {
            addPerson(newPerson);
        }
    }

    public void addPerson(Profile person) {
        if (!nameExists(person)) {
            people.add(person);
        }
    }

    public void removePerson(Profile person) {
        if (nameExists(person)) {
            people.remove(person);
        }
    }

    private boolean nameExists(Profile person) {
        return people.contains(person);
    }
    public void removePeople(Profile[] removeThesePeople) {
        for (Profile person : removeThesePeople) {
            removePerson(person);
        }
    }
    public ArrayList<Profile> getPeople() {
        return people;
    }

    public static void checkPercentages(ArrayList<Double> list) {
        double sum = 0;
        for (double num : list) {
            sum += num;
            if (num < 0) {
                throw new IllegalArgumentException("Percentages cannot be negative");
            }
        }

        if (sum != 100) {
            throw new IllegalArgumentException("Percentages do not sum to 100");
        }
    }

    public static void checkPercentages(Double[] p){
        checkPercentages(new ArrayList<>(Arrays.asList(p)));
    }

    public static double sumPercentages(ArrayList<Double> list) {
        double sum = 0;
        for (double num : list) {
            sum += num;
        }
        return sum;
    }
    public static double sumPercentages(Double[] list) {
        double sum = 0;
        for (double num : list) {
            sum += num;
        }
        return sum;
    }
    public void modifyPercentages(Double[] percentages) {
        if (percentages.length != this.people.size()) {
            throw new IllegalArgumentException("Number of percentage arguments must equal the number of people");
        }

        checkPercentages(percentages);

        this.percentages = new ArrayList<>(Arrays.asList(percentages));

    }
    public ArrayList<Double> getPercentages() {
        return this.percentages;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return this.currency;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
    public Trip getTrip() {
        return this.trip;
    }

    public void payBill() {
        this.paid = true;
    }

    public Profile getPayer() {
        return this.payer;
    }

    public HashMap<Profile, Double> getParticipants() {
        return this.participants;
    }


}

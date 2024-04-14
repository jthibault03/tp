package seedu.voyagers.classes;

import seedu.voyagers.utils.Currency;
//import seedu.voyagers.utils.FormatDate;
import seedu.voyagers.utils.Payable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//NOTE: this class uses object Double class, since it implements ArrayLists.

public class Bill implements Payable {

    private String tripName;
    private String billName;
    private double amount;
    private Currency currency;
    private Trip trip;
    private Profile payer;

    //raw Strings to be used in toString method.
    private String othersRaw;

    // hashmap with key as profile and value as the percentage of the bill they are responsible for
    // percentages must sum to 100
    private HashMap<Profile, Double> participants = new HashMap<>();

    //people on this bill.
    private ArrayList<Profile> people = new ArrayList<>();
    private ArrayList<Double> percentages = new ArrayList<>();
    private boolean paid;

    public Bill(String[] args, TripList trips) {

        //TODO: setCurrency method and null currency

        this.trip = trips.getTrip(args[0]);
        //TODO: check that error message reveals helpful info if no such trip exists
        this.tripName = args[0];
        this.billName = args[1];

        if (ProfileList.findProfile(args[2]) == -1) {
            this.payer = new Profile(args[2]);
        } else {
            this.payer = ProfileList.getProfile(args[2]);
        }
        this.amount = Double.parseDouble(args[4]);
        this.participants = setParticipants(args[4], args[2], args[3], args[5]);
        //TODO: check these args are the right index number
        this.percentages = makeDoublesArray(args[5]);
        this.currency = trip.getCurrency();
        checkPercentages(percentages);
        this.othersRaw = args[3];
        for (Profile x : participants.keySet()) {
            this.people.add(x);
        }
    }

    public Bill(String tripName, String billName, Profile payer, Double amount, Currency currency,
                ArrayList<Profile> people, ArrayList<Double> percentages) {
        if (people.size() + 1 != percentages.size()) {
            throw new IllegalArgumentException("Number of elements in 'people' and 'percentages' must be equal");
        }

        checkPercentages(percentages);

        this.participants = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            this.participants.put(people.get(i), (percentages.get(i) * amount) / 100.0);
            //TODO: check; this would be the actual amount they're responsible for
        }
        this.tripName = tripName;
        this.payer = payer;
        this.amount = amount;
        this.currency = currency;

        this.billName = billName;
        this.percentages = percentages;
        this.paid = false;
    }

    //sets default percentages to equal when no percentages are provided
    public Bill(String billName, Profile payer, Double amount, Currency currency,
                ArrayList<Profile> people) {
        int numPeople = people.size();
        double percentage = (double) 100 / numPeople;
        //TODO: check that this is compatible w the rest; this is a decimal
        Double[] percentages = new Double[numPeople];
        Arrays.fill(percentages, percentage);
        ArrayList<Double> p = new ArrayList<>(Arrays.asList(percentages));
        new Bill(tripName, billName, payer, amount, currency, people, p);
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

    public ArrayList<Double> makeDoublesArray(String input) {
        String[] inputs = input.split("\\s+");
        ArrayList<Double> arr = new ArrayList<>();
        for (String i : inputs) {
            arr.add(Double.parseDouble(i));
        }
        return arr;
    }


    public HashMap<Profile, Double> setParticipants(String amount, String payer, String others, String percentages) {
        participants.clear();
        Double amountAsDouble = Double.parseDouble(amount);
        String[] words = payer.concat(" ").concat(others).split("\\s+");
        String[] percentagesArr = percentages.split("\\s+");
        if (hasDuplicates(words)) {
            throw new IllegalArgumentException("participant names must be unique");
        }
        for (int i = 0; i < words.length; i++) {
            Profile person;
            if (ProfileList.findProfile(words[i]) == -1) {
                //Creates a profile for this person and adds them to the ProfileList if they are not already in list.
                person = new Profile(words[i]);
                ProfileList.add(person);
            } else {
                person = ProfileList.getProfile(words[i]);
            }
            participants.put(person, Double.parseDouble(percentagesArr[i]) * amountAsDouble);
        }
        return participants;
    }

    public String getName() {
        return this.billName;
    }


    public void addPeople(Profile[] newPeople) {
        for (Profile newPerson : newPeople) {
            addPerson(newPerson, this.amount / people.size());
            people.add(newPerson);
        }
    }

    public void addPerson(Profile person, Double percentage) {
        if (!nameExists(person)) {
            //refactorPercentages(); TODO: implement this method
            participants.put(person, percentage * this.amount);
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

    public boolean hasDuplicates(String[] arr) {
        HashSet<String> set = new HashSet<>();
        for (String s : arr) {
            if (!set.add(s)) { // If unable to add the element to the set, it means it's a duplicate
                return true;
            }
        }
        return false;
    }

    public static void checkPercentages(ArrayList<Double> list) {
        double sum = 0;
        for (double num : list) {
            sum += num;
            if (num < 0) {
                throw new IllegalArgumentException("Percentages cannot be negative");
            }
        }

        //In the case of number of people not divisible by 3
        if (Math.abs(sum - 100) >= 0.5) {
            throw new IllegalArgumentException("Percentages do not sum to 100");
        }
    }

    public static void checkPercentages(Double[] p) {
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
        if (percentages.length != this.participants.size()) {
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
        if (currency == null) {

        }
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

    public String listOthers() {
        String s = "";
        for (Profile p : participants.keySet()) {
            s += p.getName() + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

    public String getTripName(){
        return this.tripName;
    }


    @Override
    public String toString() {
        String s = "Trip: " + tripName + "\t\tBill Name: " +
                billName + "\t\tPayer: " +
                payer.getName() + "\t\tOthers: " + othersRaw
                + "\t\tAmount: " + amount
                + "\t\tPercentages: " + percentages
                + "\t\tCurrency: " + this.currency
                + "\t\tPaid?: " + this.paid;
        return s;
    }

    public String toStorage() {
        /*String s = "Trip: " + tripName + "\t\tBill Name: " +
                billName + "\t\tPayer: " +
                payer.getName() + "\t\tOthers: " + othersRaw
                + "\t\tAmount: " + amount
                + "\t\tPercentages: " + percentages
                + "\t\tCurrency: " + this.currency
                + "\t\tPaid?: " + this.paid;*/
        String s = tripName + "|" + billName + "|" + payer.getName() +
                "|" + amount + "|" + currency + "|" + othersRaw + "|"
                + percentages.toString().replace("[", "").
                replace("]", "") + "|"
                + paid + "\n";
        return s;
    }

    public Object getPayers() {
        return this.payer;
    }
}

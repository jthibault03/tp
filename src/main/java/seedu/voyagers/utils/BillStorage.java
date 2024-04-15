package seedu.voyagers.utils;

import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.BillList;
import seedu.voyagers.classes.Profile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BillStorage {

    public static void readBillFile(BillList billList, String currentDir, String fileName) {
        try {
            File f = new File(currentDir + "/" + fileName);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String[] inputs = s.nextLine().split("\\|", 8);
                assert inputs.length == 8 : "Invalid input format";
                //Profile payer = ProfileList.getProfile(inputs[2]);
                Profile payer = new Profile(inputs[2]);
                double amount = Double.parseDouble(inputs[3]);
                Currency currency;
                if (inputs[4].equalsIgnoreCase("null")) {
                    currency = null;
                } else {
                    currency = Currency.valueOf(inputs[4]);
                }
                ArrayList<Profile> people = new ArrayList<>();
                ArrayList<Double> percentages = new ArrayList<>();
                String[] peopleNames = inputs[5].split(" ");
                String[] percentagesString = inputs[6].split(", ");
                for (int i = 0; i < percentagesString.length; i++) {
                    percentages.add(Double.parseDouble(percentagesString[i]));
                }
                for (int i = 0; i < peopleNames.length; i++) {
                    people.add(new Profile(peopleNames[i]));
                }
                Bill bill = new Bill(inputs[0], inputs[1], payer, amount, currency, people, percentages);
                //Bill bill = Bill(String tripName, String billName, Profile payer, Double amount, Currency currency,
                //ArrayList<Profile> people, ArrayList<Double> percentages)
                if(inputs[7].equalsIgnoreCase("true")){bill.payBill();}
                billList.add(bill);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bill file not found.\nCreating new bill file...\nBill file created.");
        }
    }

    public static void writeBillFile(BillList billList, int size, String currentDir, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(currentDir + "/" + fileName);
            for (int i = 0; i < size; i++) {
                fileWriter.write(billList.get(i).toStorage());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

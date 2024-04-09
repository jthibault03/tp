package seedu.voyagers.utils;
import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.Profile;
import seedu.voyagers.classes.ProfileList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BillStorage {

    public static void readBillFile(ArrayList<Bill> bills, String currentDir, String fileName) {
        try {
            File f = new File(currentDir + "/" + fileName);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String[] inputs = s.nextLine().split("\\|", 7);
                assert inputs.length == 7 : "Invalid input format";
                Profile payer = ProfileList.getProfile(inputs[2]);
                double amount = Double.parseDouble(inputs[3]);
                Currency currency = Currency.valueOf(inputs[4]);
                ArrayList<Profile> people = new ArrayList<>();
                ArrayList<Double> percentages = new ArrayList<>();
                Bill bill = new Bill(inputs[0], inputs[1], payer, amount, currency, people, percentages);
                bills.add(bill);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bill file not found.\nCreating new bill file...\nBill file created.");
        }
    }

    public static void writeBillFile(ArrayList<Bill> bills, int size, String currentDir, String fileName){
        try {
            FileWriter fileWriter = new FileWriter(currentDir + "/" + fileName);
            for (int i = 0; i < size; i++) {
                fileWriter.write(bills.get(i).toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

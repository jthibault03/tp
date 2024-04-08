package seedu.voyagers.classes;
import seedu.voyagers.VoyagerException;

import java.util.ArrayList;

public class BillList {
    private ArrayList<Bill> bills;
    private Trip trip;

    public BillList(int size) {
        this.bills = new ArrayList<Bill>(size);
    }

    public BillList(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public void add(Bill bill) {
        if (isBillNameRepeated(bill.getName())) {
            throw new IllegalArgumentException("Bill name already exists");
        }
        this.bills.add(bill);
    }

    /**
     * Removes a bill from the list
     * @param index the index of the bill to remove. Index starts from 1
     * @return the bill that was removed
     * @throws VoyagerException if the index is invalid
     */
    public Bill remove(String index) throws VoyagerException{
        Bill bill = bills.get(checkIndex(index) - 1);
        this.bills.remove(checkIndex(index) - 1);
        return bill;
    }

    public ArrayList<Bill> getList(){
        return this.bills;
    }

    /**
     * Removes a bill from the list
     * @param index the index of the bill to remove. Index starts from 0
     * @return the bill that was removed
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public Bill remove(int index) throws IndexOutOfBoundsException{
        Bill bill = bills.get(index);
        this.bills.remove(index);
        return bill;
    }

    /**
     * Returns the bill at the specified index
     * @param index the index of the bill to return. Index starts from 0
     * @return the bill at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public Bill get(int index) throws IndexOutOfBoundsException{
        return this.bills.get(index);
    }

    /**
     * Returns the bill at the specified index
     * @param index the index of the bill to return. Index starts from 1
     * @return the bill at the specified index
     * @throws VoyagerException if the index is invalid
     */
    public Bill get(String index) throws VoyagerException{
        return this.bills.get(checkIndex(index) - 1);
    }

    /**
     * Tries to parse the index to an integer and checks if it is within the range of the list.
     * Index starts from 1.
     * @param index the index to check
     * @return the index as an integer
     */
    private int checkIndex(String index) throws VoyagerException{
        int i;
        try{
            i = Integer.parseInt(index);
        } catch (NumberFormatException e){
            throw new VoyagerException("Please enter a valid number");
        }

        if (i > this.bills.size() || i < 1){
            throw new VoyagerException("Sorry. There are only " + bills.size() + " bill(s) in the list");
        }

        return i;
    }

    public void setBill(int index, Bill bill){
        this.bills.set(index, bill);
    }

    /**
     * Finds the index of the bill with the specified name
     * @param name the name of the bill to find
     * @return the index of the bill with the specified name. Returns -1 if no such bill is found
     */
    public int findBill(String name){
        for (int i = 0; i < bills.size(); i++){
            if (bills.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public Bill getBill(String name) throws IllegalArgumentException{
        int index = findBill(name);
        if (index == -1){
            throw new IllegalArgumentException("No such trip found");
        }
        return bills.get(index);
    }

    public boolean isBillNameRepeated(String name){
        return findBill(name) != -1;
    }



    public ArrayList<Bill> getBills(){
        return this.bills;
    }

    /**
     * Returns the number of bills in the list
     * @return the number of bills in the list
     */
    public int size(){
        return this.bills.size();
    }
}

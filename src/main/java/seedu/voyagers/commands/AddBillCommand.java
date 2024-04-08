package seedu.voyagers.commands;

import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.classes.BillList;

public class AddBillCommand extends Command {
    public AddBillCommand(String[] args){
        super(args);
    }

    //"/trip", "/n", "/payer", "/people", "/amount", "/percentages"} <-- these are the args. theyre all strings now.
    //TODO: also need currency

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){

        try{
            Bill bill = new Bill(args);
            bills = bill.getTrip().getBillList(); //TODO: implement a way to get all the bills associated with a certain trip.
            bills.add(bill);
            //new AutoBillStatusUpdateCommand().execute(bills, ui, null);
            ui.echo("Got it. I've added this bill:\n" + bill
                    + "\nNow you have " + bills.size() +
                    " bill(s) in the list.");
        } catch (Exception e){
            ui.echo(e.getMessage());
        }

        //storage.writeTripFile(trips, trips.size());
    }

}

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

    //TODO: also need currency

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){

        try{
            Bill bill = new Bill(args, trips);
            bill.getTrip().addBill(bill);
            BillList bills = bill.getTrip().getBills();
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

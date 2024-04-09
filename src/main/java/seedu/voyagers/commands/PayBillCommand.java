package seedu.voyagers.commands;

import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.BillList;
import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

public class PayBillCommand extends Command{

    public PayBillCommand(String[] args) {
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        try{
            Bill bill = BillList.getBill(args[0]);
            bill.payBill();
            ui.echo("Got it. This bill is now marked as paid.");
        } catch (Exception e){
            ui.echo(e.getMessage());
        }
    }
}

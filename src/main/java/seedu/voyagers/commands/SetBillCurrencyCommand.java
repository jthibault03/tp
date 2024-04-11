package seedu.voyagers.commands;

import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.BillList;
import seedu.voyagers.classes.TripList;
//import seedu.voyagers.utils.Currency;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

public class SetBillCurrencyCommand extends Command{

    public SetBillCurrencyCommand(String[] args) {
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        try{
            Bill bill = BillList.getBill(args[0]);
            //TODO: Implement this
            //Currency currency = args[1]
            //bill.setCurrency(currency);
            ui.echo("Got it. This bill is now marked as paid.");
        } catch (Exception e){
            ui.echo(e.getMessage());
        }
    }
}


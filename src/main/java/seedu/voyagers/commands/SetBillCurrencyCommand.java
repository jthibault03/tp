package seedu.voyagers.commands;

import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.BillList;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Currency;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

public class SetBillCurrencyCommand extends Command{

    public SetBillCurrencyCommand(String[] args) {
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        try{
            Bill bill = BillList.getBill(args[0], args[1]);
            Currency curr = Currency.getCurr(args[2]);

            bill.setCurrency(curr);
            ui.echo("Got it. Updated this bill's currency.");
        } catch (Exception e){
            ui.echo(e.getMessage());
        }
    }
}


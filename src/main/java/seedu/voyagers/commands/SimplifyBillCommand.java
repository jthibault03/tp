package seedu.voyagers.commands;
import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.BillList;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.classes.billsettler.BillSettler;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

import java.util.ArrayList;
import java.util.Objects;

public class SimplifyBillCommand extends Command{
    public void execute (TripList trips, Ui ui, TripStorage tripStorage){
        if (trips.size() == 0) {
            ui.echo("You have no bills in your list.");
            return;
        } else {
            BillList billList = null;
            ArrayList<Bill> bills = new ArrayList<>();
            for (int i = 0; i < trips.size(); i++) {
                billList = trips.get(i).getBills();
            }
            for (int j = 0; j < Objects.requireNonNull(billList).size(); j++) {
                bills.add(billList.get(j));
            }
            BillSettler.createGraphForDebts(bills);
        }
    }
}
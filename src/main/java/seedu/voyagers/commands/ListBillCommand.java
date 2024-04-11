package seedu.voyagers.commands;

import seedu.voyagers.classes.BillList;
//import seedu.voyagers.classes.Bill;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

//import java.util.ArrayList;

public class ListBillCommand extends Command{
    public void execute(TripList trips, Ui ui, TripStorage tripStorage){


        if (trips.size() == 0){
            ui.echo("You have no bills in your list.");
            return;
        }

        ui.echo("Here are the bills in your list:");
        int counter = 0;
        for (int i = 0; i < trips.size(); i++){
            BillList bills = trips.get(i).getBills();
            for (int j = 0; j < bills.size(); j++) {
                ui.echo((counter + 1) + ". " + bills.get(j));
                counter++;
            }
        }

        if (counter == 0) {
            ui.echo("You have no bills in your list.");
            return;
        }
    }
}

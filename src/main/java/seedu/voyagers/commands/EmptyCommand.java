package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;


public class EmptyCommand extends Command{

    public EmptyCommand(){
        super(new String[0]);
    }
    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
      //do nothing
    }
}

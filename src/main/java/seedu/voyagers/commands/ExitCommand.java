package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;

public class ExitCommand extends Command{
    public ExitCommand(){
    }

    /**
     * Executes the command to exit the program.
     * Prints the goodbye message.
     * @param trips the list of trips
     * @param ui the user interface
     * @param tripStorage the storage
     */
    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        String currentDir = System.getProperty("user.dir");
        final String TRIPS_FILE_NAME = "local-voyagers.txt";
        TripStorage.writeTripFileMain(trips.getTrips(), trips.size(),currentDir, TRIPS_FILE_NAME);
        ui.showExit();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}

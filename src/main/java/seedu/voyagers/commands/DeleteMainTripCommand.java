package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.classes.Trip;

public class DeleteMainTripCommand extends Command{

    public DeleteMainTripCommand(String[] args){
        super(args);
    }
    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        String currentDir = System.getProperty("user.dir");
        final String tripsFileName = "local-voyagers.txt";
        int index = trips.findTrip(args[0]);

        if (index == -1){
            ui.echo("No such trip found");
            return;
        }

        Trip trip = trips.remove(index);
        ui.echo("Noted. I've removed this trip:\n" + trip
                + "\nNow you have " + trips.size() +
                " trips in the list.");
        TripStorage.writeTripFileMain(trips.getTrips(), trips.size(),currentDir, tripsFileName);
    }

}

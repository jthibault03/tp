package seedu.voyagers.commands;

import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

public class DeleteSubTripCommand extends Command{

    public DeleteSubTripCommand(String[] args){
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

        Trip trip = trips.get(index);
        int subTripIndex = Integer.parseInt(args[1]) - 1;
        Trip subTrip = trip.getSubTrip(subTripIndex);
        ui.echo("Noted. I've removed this subtrip:\n" + subTrip);
        trip.removeSubTrip(subTripIndex);
        TripStorage.writeTripFileMain(trips.getTrips(), trips.size(),currentDir, tripsFileName);
    }

}

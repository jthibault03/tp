package seedu.voyagers.commands;

import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Status;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;
import java.util.Date;

public class AutoTripStatusUpdateCommand {
    public void execute(TripList trips, Ui ui, TripStorage tripStorage) {
        String currentDir = System.getProperty("user.dir");
        final String TRIPS_FILE_NAME = "local-voyagers.txt";
        Date currentDate = new Date();

        for (int i = 0; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            if (trip.getStatus() == null) {
                //System.out.println("Trip status is null");
                if (trip.getEndDate().before(currentDate)) {
                   // System.out.println("Trip end date is before current date");
                    trip.setStatus(Status.COMPLETED);
                } else if (trip.getStartDate().after(currentDate)) {
                    //System.out.println("Trip start date is after current date");
                    trip.setStatus(Status.UPCOMING);
                    //System.out.println("Trip status is now " + trip.getStatus());
                } else {
                    //System.out.println("Trip is ongoing");
                    trip.setStatus(Status.ONGOING);
                   // System.out.println("Trip status is now " + trip.getStatus());
                }
            }

            else if (trip.getEndDate().before(currentDate) && (trip.getStatus() == Status.ONGOING ||
                    trip.getStatus() == Status.UPCOMING) ) {
                trip.setStatus(Status.COMPLETED);
                ui.echo("Trip " + trip.getName() + " has ended. It is now marked as completed.");
            }
            else if (trip.getStartDate().before(currentDate) && trip.getEndDate().after(currentDate)
                    && trip.getStatus() == Status.UPCOMING) {
                trip.setStatus(Status.ONGOING);
                ui.echo("Trip " + trip.getName() + " has started. It is now marked as ongoing.");
            }
        }

        TripStorage.writeTripFile(trips.getTrips(), trips.size(),currentDir, TRIPS_FILE_NAME);
    }
}

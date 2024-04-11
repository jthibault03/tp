package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.FormatDate;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.classes.Trip;

import java.text.ParseException;
import java.util.Date;

//TODO: check dates make sense with main trip
public class AddSubTripCommand extends Command{

    public AddSubTripCommand(String[] args){
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage) {
        Trip mainTrip = null;
        String[] newArgs = new String[args.length - 1];
        System.arraycopy(args, 1, newArgs, 0, args.length - 1);

        try{
            mainTrip = trips.getTrip(newArgs[0]);
        } catch (Exception e){
            ui.echo(e.getMessage());
            return;
        }

        Date mainTripStart = mainTrip.getStartDate();
        Date mainTripEnd = mainTrip.getEndDate();
        Date subTripStart = null;
        Date subTripEnd = null;
        try {
            subTripStart = FormatDate.dateFormat.parse(newArgs[1]);
            subTripEnd = FormatDate.dateFormat.parse(newArgs[2]);
        } catch (ParseException e) {
            ui.echo("Failure to parse dates in AddSubTripCommand");
            return;
        }

        if (mainTripStart.after(subTripStart) || mainTripEnd.before(subTripEnd)){
            ui.echo("This trip is not within the main trip's dates");
            return;
        }

        if (subTripStart.after(subTripEnd)){
            ui.echo("The start date of this trip is after the end date");
            return;
        }

        try{
            Trip trip = new Trip(newArgs);
            trip.setTripType("sub");
            mainTrip.addSubTrip(trip);
            ui.echo("Got it. I've added this trip as a subtrip of :" + mainTrip.getName() + "\n" + trip
                    + "\nNow you have " + mainTrip.getSubTripsSize() +
                    " subtrips.");
            trips.add(trip);
        } catch (Exception e){
            ui.echo(e.getMessage());
        }

        String currentDir = System.getProperty("user.dir");
        final String tripsFileName = "local-voyagers.txt";
        TripStorage.writeTripFileMain(trips.getTrips(), trips.size(),currentDir, tripsFileName);
    }
}

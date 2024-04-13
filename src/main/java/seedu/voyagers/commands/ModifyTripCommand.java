package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.FormatDate;
import seedu.voyagers.utils.Status;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.classes.Trip;

import java.util.Date;

public class ModifyTripCommand extends Command{

    public ModifyTripCommand(String[] args){
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){

        String oldName = args[1];
        String modificationType = args[0];

        int index = trips.findTrip(oldName);
        if (index == -1){
            ui.echo("No such trip found");
            return;
        }

        Trip trip = trips.get(index);

        switch (modificationType){
        case "name":
            if (trips.findTrip(args[2]) != -1){
                ui.echo("A trip with that name already exists");
                return;
            }
            trip.setName(args[2]);
            break;
        case "dates":
            try{
                Date newStartDate = FormatDate.dateFormat.parse(args[2]);
                Date newEndDate = FormatDate.dateFormat.parse(args[3]);
                trip.setDates(newStartDate, newEndDate);
            } catch (Exception e){
                //TODO: be more descriptive about the error (e.g. invalid date format,
                // start date after end date, etc.)
                ui.echo("Invalid dates");
                return;
            }
            break;
        case "location":
            trip.setLocation(args[2]);
            break;
        case "description":
            trip.setDescription(args[2]);
            break;
        case "status":
            if (args[2].equalsIgnoreCase( "cancel")) {
                trip.setStatus(Status.CANCELLED);
            } else if (args[2].equalsIgnoreCase("uncancel")) {
                trip.setStatus(null);
                new AutoTripStatusUpdateCommand().execute(trips, ui, null);
            }
            break;
        default:
            ui.echo("Invalid modification type");
            return;
        }

        ui.echo("Noted. I've modified this trip:\n" + trip);
        String currentDir = System.getProperty("user.dir");
        final String tripsFileName = "local-voyagers.txt";
        TripStorage.writeTripFileMain(trips.getTrips(), trips.size(),currentDir, tripsFileName);
    }
}

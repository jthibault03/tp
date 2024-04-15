package seedu.voyagers.commands;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.classes.Trip;

import java.util.ArrayList;

public class AddTripCommand extends Command{

    /**
     * Constructor for AddTripCommand
     * @param args args[0]= name, args[1]= location, args[2]= start date, args[3]= end date, args[4]= description
     */
    public AddTripCommand(String[] args){
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        String currentDir = System.getProperty("user.dir");
        final String tripsFileName = "local-voyagers.txt";

        try{
            String[] checkStartDate = args[1].split("-", 3);
            String[] checkEndDate = args[2].split("-", 3);
            if (Integer.parseInt(checkStartDate[1]) > 12 || Integer.parseInt(checkStartDate[1]) < 1){
                throw new IllegalArgumentException("Invalid starting month");
            }
            if (Integer.parseInt(checkEndDate[1]) > 12 || Integer.parseInt(checkEndDate[1]) < 1){
                throw new IllegalArgumentException("Invalid ending month");
            }
            if (Integer.parseInt(checkStartDate[2]) > 31 || Integer.parseInt(checkStartDate[2]) < 1){
                throw new IllegalArgumentException("Invalid starting day");
            }
            if (Integer.parseInt(checkEndDate[2]) > 31 || Integer.parseInt(checkEndDate[2]) < 1){
                throw new IllegalArgumentException("Invalid ending day");
            }
            Trip trip = new Trip(args);
            trip.setTripType("main");
            trips.add(trip);
            new AutoTripStatusUpdateCommand().execute(trips, ui, null);
            ui.echo("Got it. I've added this trip:\n" + trip
                    + "\nNow you have " + trips.size() +
                    " trips in the list.");
        } catch (Exception e){
            ui.echo(e.getMessage());
        }

        TripStorage.writeTripFileMain(trips.getTrips(), trips.size(),currentDir, tripsFileName);
    }

}

package seedu.voyagers;

import seedu.voyagers.classes.TripList;
import seedu.voyagers.commands.AutoTripStatusUpdateCommand;
import seedu.voyagers.paser.NewParser;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.commands.Command;
import seedu.voyagers.commands.ListCommand;

import java.util.ArrayList;

import static seedu.voyagers.utils.ReviewStorage.readReviewFile;
import static seedu.voyagers.utils.ReviewStorage.writeReviewFile;
import static seedu.voyagers.utils.TripStorage.readTripFile;
import static seedu.voyagers.utils.TripStorage.writeTripFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Voyagers {

    private static final String TRIPS_FILE_NAME = "local-voyagers.txt";

    private static final String REVIEWS_FILE_NAME = "local-reviews.txt";

    //TODO: change to private and add to the command.execute(Ui, tripList, storage)
    public TripList tripList;
    public Ui ui;

    public Voyagers() {
        this.tripList = new TripList(new ArrayList<>());
        this.ui = new Ui();
    }
    public static void main(String[] args) {
        new Voyagers().run();
    }

    void run() {

        Logger logger = Logger.getLogger("Voyagers");
        logger.setLevel(Level.INFO);

        ui.showWelcome();
        //assert false : "This is a debug assertion set to fail.";
        ui.echo("Here are the trips in your list from the previous time:", false, false);

        //TODO: make Storage a singleton
        String currentDir = System.getProperty("user.dir");
        //TODO: check
        readTripFile(tripList.getTrips(), currentDir, TRIPS_FILE_NAME);
        readReviewFile(tripList, currentDir, REVIEWS_FILE_NAME);


        new ListCommand().execute(tripList, ui, null);
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = NewParser.parse(fullCommand);
                c.execute(tripList, ui, null);
                isExit = c.isExit();

            } catch (Exception e) { //TODO: change to specific exceptions
                ui.echo(e.getMessage());
            }
        }

        writeTripFile(tripList.getTrips(), tripList.size(), currentDir, TRIPS_FILE_NAME);
        writeReviewFile(tripList, tripList.size(), currentDir, REVIEWS_FILE_NAME);
    }

}

package seedu.voyagers;

import seedu.voyagers.classes.BillList;
import seedu.voyagers.classes.Profile;
import seedu.voyagers.classes.ProfileList;
import seedu.voyagers.classes.TripList;
//import seedu.voyagers.commands.AutoTripStatusUpdateCommand;
import seedu.voyagers.paser.NewParser;
import seedu.voyagers.utils.Ui;
import seedu.voyagers.commands.Command;
import seedu.voyagers.commands.ListCommand;

import java.util.ArrayList;

import static seedu.voyagers.utils.BillStorage.readBillFile;
import static seedu.voyagers.utils.ProfileStorage.readProfileFile;
import static seedu.voyagers.utils.ReviewStorage.readReviewFile;
import static seedu.voyagers.utils.ReviewStorage.writeReviewFileMain;
import static seedu.voyagers.utils.TripStorage.readTripFile;
import static seedu.voyagers.utils.TripStorage.writeTripFileMain;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Voyagers {

    private static final String TRIPS_FILE_NAME = "local-voyagers.txt";

    private static final String REVIEWS_FILE_NAME = "local-reviews.txt";

    private static final String BILLS_FILE_NAME = "local-bills.txt";

    private static final String PROFILES_FILE_NAME = "local-profiles.txt";

    //TODO: change to private and add to the command.execute(Ui, tripList, storage)
    public TripList tripList;
    public ProfileList profileList;
    public BillList billList;
    public Ui ui;

    public Voyagers() {
        this.tripList = new TripList(new ArrayList<>());
        billList = new BillList(new ArrayList<>());
        profileList = new ProfileList(new ArrayList<Profile>());
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
        //TODO: load in Profiles and Bills from save file
        readBillFile(billList, currentDir, BILLS_FILE_NAME);
        readProfileFile(profileList, currentDir, PROFILES_FILE_NAME);

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

        writeTripFileMain(tripList.getTrips(), tripList.size(), currentDir, TRIPS_FILE_NAME);
        writeReviewFileMain(tripList, tripList.size(), currentDir, REVIEWS_FILE_NAME);
    }

}

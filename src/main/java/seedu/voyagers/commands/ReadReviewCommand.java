package seedu.voyagers.commands;

import seedu.voyagers.classes.Review;
import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

import java.util.Arrays;

public class ReadReviewCommand extends Command{

    public ReadReviewCommand(String[] args){
        super(args);
    }

    public void execute(TripList trips, Ui ui, TripStorage tripStorage){
        String tripName = args[1];

        int index = trips.findTrip(tripName);
        if (index == -1){
            ui.echo("No such trip found");
            return;
        }

        Trip trip = trips.get(index);
        assert trip != null;
        Review review= trip.getReview();
        if(review.getScore() == -1){
            ui.echo("This trip: '" + tripName + "' has not been reviewed");
            return;
        }
        ui.echo(review.toString());
    }

}

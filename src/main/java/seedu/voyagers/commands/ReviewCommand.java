package seedu.voyagers.commands;

import seedu.voyagers.classes.Review;
import seedu.voyagers.classes.Trip;
import seedu.voyagers.classes.TripList;
import seedu.voyagers.utils.TripStorage;
import seedu.voyagers.utils.Ui;

import static java.lang.Integer.parseInt;

public class ReviewCommand extends Command{

    public ReviewCommand(String[] args){
        super(args);
    }

    @Override
    public void execute(TripList trips, Ui ui, TripStorage tripStorage) {

        String tripName = args[1];

        int index = trips.findTrip(tripName);
        if (index == -1){
            ui.echo("No such trip found");
            return;
        }

        Trip trip = trips.get(index);

        int score = parseInt(args[2]);
        String reflection = args[3];
        if(score < 1 || score > 10){
            ui.echo("Score must be between 0 and 10");
            return;
        }
        assert trip != null;
        assert score >= 1 && score <= 10;
        Review review = trip.getReview();
        review.setScore(score);
        review.setReflection(reflection);
        ui.echo("Noted. you reviewed this trip:\n" + tripName + " with a score of " +
                + review.getScore() + ", noting: " + review.getReflection());
    }


}

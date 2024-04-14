package seedu.voyagers.classes;

import static java.lang.Integer.parseInt;

public class Review {

    private int score;

    private String reflection;

    private Trip trip;

    public Review(){
        this.score = -1;
        this.reflection = "empty";
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScore(String score) {
        this.score = parseInt(score);
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    public int getScore() {
        return score;
    }

    public String getReflection() {
        return reflection;
    }

    @Override
    public String toString() {
        return "Here's what you wrote about " + this.trip.getName() + "\n\t\tScore: " + score
                + "\n\t\tReflection:\n\t\t" + reflection;
    }

}

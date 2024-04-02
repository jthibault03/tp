package seedu.voyagers.classes;

import static java.lang.Integer.parseInt;

public class Review {

    private int score;

    private String reflection;

    public Review(){
        this.score = -1;
        this.reflection = "empty";
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
    public String toString(){
        return "Score: " + score + ", Reflection: " + reflection;
    }
}

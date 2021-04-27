package dk.QuizGame.domain;

public class Points {

    private final int points;

    public Points(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                '}';
    }
}

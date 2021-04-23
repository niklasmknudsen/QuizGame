package dk.howard.domain;

import java.io.Serializable;

public class Points implements Serializable {

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

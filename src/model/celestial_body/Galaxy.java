package model.celestial_body;

import java.io.IOException;
import java.util.Random;

import view.celestial_body.ViewStar;

public class Galaxy {
    // CLASS CONSTANTS
    public static final int numStars = 500;
    public static final int gaussianDeviation = 1000;

    // INSTANCE VARIABLES
    private Star[] stars;
    private ViewStar[] viewStars;

    // CONSTRUCTORS
    public Galaxy() throws IOException {
        stars = new Star[numStars];
        viewStars = new ViewStar[stars.length];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star((int) (0 + gaussianDeviation * new Random().nextGaussian()),
                    (int) (0 + gaussianDeviation * new Random().nextGaussian()));
            viewStars[i] = new ViewStar(stars[i]);
        }
    }

    // GETTERS
    public Star[] getStars() {
        return stars;
    }

    public ViewStar[] getViewStars() {
        return viewStars;
    }
}

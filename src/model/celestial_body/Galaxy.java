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
            // Generate random gaussian distribution for x and y between -2000 and 2000
            int max = 2500;
            int min = -2500;
            int x = (int) (0 + gaussianDeviation * new Random().nextGaussian());
            int y = (int) (0 + gaussianDeviation * new Random().nextGaussian());

            if (x < min) {  x = min; } else if (x > max) { x = max; }
            if (y < min) { y = min; } else if (y > max) { y = max; }

            stars[i] = new Star(x, y);
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

package model.celestial_body;

import java.io.File;

public class Star {
    // CLASS CONSTANTS
    public static final int WIDTH = 128;
    public static final int HEIGHT = 128;

    // INSTANCE VARIABLES
    private int x;
    private int y;
    private String model;
    private Planet[] planets;

    // CONSTRUCTORS
    public Star(int x, int y) {
        this.x = x;
        this.y = y;
        File[] starFiles = new File("assets/stars/mini").listFiles();
        this.model = starFiles[(int) (Math.random() * starFiles.length)].getName();
        this.planets = new Planet[(int) (Math.random() * 5)];
        for (int i = 0; i < planets.length; i++) {
            planets[i] = new Planet(x, y, false);
        }
    }

    // GETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getModel() {
        return model;
    }

    public Planet[] getPlanets() {
        return planets;
    }

    // SETTERS
    public void setX(int x) {
        this.x = x;
        for (Planet planet : planets) {
            planet.setX(x);
        }
    }

    public void setY(int y) {
        this.y = y;
        for (Planet planet : planets) {
            planet.setY(y);
        }
    }

    // METHODS
    public String toString() {
        String result = "";
        result += "Star at (" + x + ", " + y + ")\n";
        for (Planet planet : planets) {
            result += "\t" + planet.toString() + "\n";
        }
        return result;
    }
}

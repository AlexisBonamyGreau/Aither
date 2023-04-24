package model.celestial_body;

import java.io.File;

public class Planet {
    // CLASS CONSTANTS
    public static final int ROCK_WIDTH = 64;
    public static final int ROCK_HEIGHT = 64;
    public static final int GAS_WIDTH = 128;
    public static final int GAS_HEIGHT = 128;

    // INSTANCE VARIABLES
    private int x;
    private int y;
    private int width;
    private int height;
    private String model;
    private boolean isGasGiant;

    // CONSTRUCTORS
    public Planet(int x, int y, boolean isGasGiant) {
        this.x = x;
        this.y = y;
        if (isGasGiant) {
            this.width = GAS_WIDTH;
            this.height = GAS_HEIGHT;
            File[] gasGiantFiles = new File("assets/planets/gas").listFiles();
            this.model = gasGiantFiles[(int) (Math.random() * gasGiantFiles.length)].getName();
        } else {
            this.width = ROCK_WIDTH;
            this.height = ROCK_HEIGHT;
            File[] planetFiles = new File("assets/planets/rock").listFiles();
            this.model = planetFiles[(int) (Math.random() * planetFiles.length)].getName();
        }
        this.isGasGiant = isGasGiant;
    }

    // GETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getModel() {
        return model;
    }

    public boolean isGasGiant() {
        return isGasGiant;
    }

    // SETTERS
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setGasGiant(boolean gasGiant) {
        isGasGiant = gasGiant;
    }

    // METHODS
    public String toString() {
        return "Planet{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", model='" + model + '\'' +
                ", isGasGiant=" + isGasGiant +
                '}';
    }
}

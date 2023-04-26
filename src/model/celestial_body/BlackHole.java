package model.celestial_body;

public class BlackHole {
    // CLASS CONSTANTS
    public static final int WIDTH = 256;
    public static final int HEIGHT = 256;

    // INSTANCE VARIABLES
    private int x;
    private int y;
    private String model;

    // CONSTRUCTOR
    public BlackHole() {
        this.x = 0;
        this.y = 0;
        this.model = "assets/black_hole/black_hole.png";
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
}

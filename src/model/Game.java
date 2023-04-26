package model;

import java.io.IOException;

import javax.swing.JFrame;

import controller.tools.AitherTool;
import model.celestial_body.Galaxy;
import model.entities.Ship;
import view.gui.MapGalaxy;

public class Game {
    // INSTANCE VARIABLES
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    private Galaxy galaxy;
    private Ship ship;
    private enum State {
        MENU, PAUSE, GALAXY, STELLAR_SYSTEM
    }
    private State state;

    // CONSTRUCTORS
    public Game() throws IOException {
        this.galaxy = new Galaxy();
        this.ship = new Ship();
        this.state = State.GALAXY;
    }

    // GETTERS
    public Galaxy getGalaxy() {
        return galaxy;
    }

    public Ship getShip() {
        return ship;
    }

    public State getState() {
        return state;
    }

    // METHODS
    public void update(JFrame frame) throws IOException {
        switch (state) {
            case GALAXY:
                voidGalaxy(frame);
                break;
            case STELLAR_SYSTEM:
                System.out.println("STELLAR_SYSTEM");
                state = State.GALAXY;
                break;
            case MENU:
                break;
            case PAUSE:
                break;
        }
    }

    public void voidGalaxy(JFrame frame) throws IOException {
        MapGalaxy mapGalaxy = new MapGalaxy(WIDTH, HEIGHT, galaxy);
        AitherTool aitherTool = new AitherTool();
        mapGalaxy.associateTool(aitherTool);
        frame.add(mapGalaxy);

        // start a second thread to update the state of the map
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    mapGalaxy.updateState();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

        mapGalaxy.updateState();
    }
}

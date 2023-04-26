package model;

import java.io.IOException;

import javax.swing.JFrame;

import controller.tools.AitherTool;
import model.celestial_body.Galaxy;
import model.entities.Ship;
import view.gui.MapGalaxy;

public class Game {
    // INSTANCE VARIABLES
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private Galaxy galaxy;
    private Ship ship;
    private enum State {
        MENU, PAUSE, GALAXY, STELLAR_SYSTEM
    }
    private State state;
    private JFrame frame;

    private MapGalaxy mapGalaxy;

    private AitherTool aitherTool;

    // CONSTRUCTORS
    public Game(JFrame frame) throws IOException {
        this.galaxy = new Galaxy();
        this.ship = new Ship();
        this.state = State.GALAXY;
        this.frame = frame;

        this.mapGalaxy = new MapGalaxy(this, WIDTH, HEIGHT, galaxy);

        this.aitherTool = new AitherTool();
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

    // STATE METHODS
    public void setStateGalaxy() {
        state = State.GALAXY;
    }

    public void setStateStellarSystem() {
        state = State.STELLAR_SYSTEM;
    }

    public void setStateMenu() {
        state = State.MENU;
    }

    public void setStatePause() {
        state = State.PAUSE;
    }

    // METHODS
    public void update() throws IOException {
        switch (state) {
            case GALAXY:
                voidGalaxy(this.frame);
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
        mapGalaxy.associateTool(aitherTool);
        frame.add(mapGalaxy);
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

package model;

import java.io.IOException;

import javax.swing.JFrame;

import controller.tools.ToolMapGalaxy;
import model.celestial_body.Galaxy;
import model.entities.Ship;
import view.celestial_body.ViewStar;
import view.gui.MapGalaxy;
import view.gui.MapStellarSystem;

public class Game {
    // INSTANCE VARIABLES
    private Galaxy galaxy;
    private Ship ship;
    private enum State {
        MENU, PAUSE, GALAXY, STELLAR_SYSTEM
    }
    private State state;
    private JFrame frame;
    private MapGalaxy mapGalaxy;
    private ToolMapGalaxy aitherTool;
    private ViewStar currentStar;

    // CONSTRUCTORS
    public Game(JFrame frame, int width, int height) throws IOException {
        this.galaxy = new Galaxy();
        this.ship = new Ship();
        this.state = State.GALAXY;
        this.frame = frame;

        this.mapGalaxy = new MapGalaxy(this, width, height, galaxy);

        this.aitherTool = new ToolMapGalaxy();
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

    // SETTERS
    public void setCurrentStar(ViewStar star) {
        this.currentStar = star;
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
                clearFrame();
                voidGalaxy(this.frame);
                break;
            case STELLAR_SYSTEM:
                clearFrame();
                voidStellarSystem(this.frame);
                break;
            case MENU:
                break;
            case PAUSE:
                break;
        }
    }

    public void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
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
        frame.setVisible(true);
    }

    public void voidStellarSystem(JFrame frame) {
        System.out.println("voidStellarSystem");
        MapStellarSystem mapStellarSystem = new MapStellarSystem(this, currentStar);
        frame.add(mapStellarSystem);
        // mapStellarSystem.updateState();
        frame.setVisible(true);
    }
}

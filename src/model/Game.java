package model;

import java.io.IOException;

import javax.swing.JFrame;

import controller.tools.ToolMapGalaxy;
import controller.tools.ToolMapStellarSystem;
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
    private MapStellarSystem mapStellarSystem;
    private ViewStar currentStar;

    private ToolMapGalaxy toolMapGalaxy;
    private ToolMapStellarSystem toolMapStellarSystem;

    // CONSTRUCTORS
    public Game(JFrame frame, int width, int height) throws IOException {
        this.galaxy = new Galaxy();
        this.ship = new Ship();
        this.state = State.GALAXY;
        this.frame = frame;

        this.currentStar = new ViewStar(galaxy.getStars()[0]);

        this.mapGalaxy = new MapGalaxy(this, width, height, galaxy);
        this.mapStellarSystem = new MapStellarSystem(this, currentStar);

        this.toolMapGalaxy = new ToolMapGalaxy();
        this.toolMapStellarSystem = new ToolMapStellarSystem();

        // Thread thread = new Thread() {
        //     public void run() {
        //         while (true) {
        //             mapGalaxy.updateState();
        //             mapStellarSystem.updateState();
        //             try {
        //                 Thread.sleep(500);
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // };
        // thread.start();
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
        mapGalaxy.associateTool(toolMapGalaxy);
        frame.add(mapGalaxy);
        frame.setVisible(true);
    }

    public void voidStellarSystem(JFrame frame) {
        System.out.println(currentStar.getStar().toString());
        mapStellarSystem = new MapStellarSystem(this, currentStar);
        mapStellarSystem.associateTool(toolMapStellarSystem);
        frame.add(mapStellarSystem);
        frame.setVisible(true);
    }
}

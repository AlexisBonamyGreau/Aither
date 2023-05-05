package controller.tools;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;

import javax.swing.event.MouseInputListener;

import view.gui.MapStellarSystem;

public class ToolMapStellarSystem implements MouseInputListener, MouseWheelListener {
    // INSTANCE VARIABLES
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private MapStellarSystem map;

    // SETTERS
    public void setMapSterllarSystem(MapStellarSystem map) {
        this.map = map;
    }

    // OTHER METHODS
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            map.click(e.getX(), e.getY());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        map.setX(map.getX() - e.getWheelRotation() * 100);
        map.repaint();
    }
}

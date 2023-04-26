package controller.tools;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputListener;

import view.gui.MapGalaxy;

public class AitherTool implements MouseInputListener, MouseWheelListener {
    // INSTANCE VARIABLES
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private MapGalaxy map;

    // GETTERS
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    // SETTERS
    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setMapGalaxy(MapGalaxy map) {
        this.map = map;
    }

    // OTHER METHODS
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        map.click(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        map.move(x2-x1, y2-y1);
        map.repaint();

        x1 = x2;
        y1 = y2;
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int x = e.getX() - map.getWidth()/2;
        int y = e.getY() - map.getHeight()/2;
        if (e.getWheelRotation() < 0) {
            map.resize(2, x, y);
        } else {
            map.resize(0.5, x, y);
        }
    }
}

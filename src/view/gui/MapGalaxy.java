package view.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import controller.tools.AitherTool;
import model.celestial_body.Galaxy;
import view.celestial_body.ViewStar;

public class MapGalaxy extends JPanel {
    // CLASS CONSTANTS
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    public static final int BG_SCALE = 2048;

    // INSTANCE VARIABLES
    private Galaxy galaxy;
    private Image background;
    private int state;
    private int x;
    private int y;
    private int size;

    // CONSTRUCTORS
    public MapGalaxy(int width, int height) throws IOException {
        this.x = 0;
        this.y = 0;
        this.size = 1;
        this.state = 0;

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(java.awt.Color.BLUE);

        this.galaxy = new Galaxy();

        this.background = javax.imageio.ImageIO.read(new File("assets/bg.jpg"));
    }

    // GETTERS
    public Galaxy getGalaxy() {
        return galaxy;
    }

    // SETTERS

    // METHODS
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        int bgX = (this.x + WIDTH/2) / 3 - BG_SCALE*size/3;
        int bgY = (this.y + HEIGHT/2) / 3 - BG_SCALE*size/3;
        int width = BG_SCALE*size;
        int height = BG_SCALE*size;
        g.drawImage(background, bgX, bgY, width, height, null);
        for (ViewStar star : galaxy.getViewStars()) {
            star.draw((java.awt.Graphics2D) g, x+WIDTH/2, y+HEIGHT/2, size, state);
        }
    }

    public void update() {
        state = (state + 1) % 16;
    }

    public void associateTool(AitherTool tool) {
        tool.setMapGalaxy(this);
        this.addMouseListener(tool);
        this.addMouseMotionListener(tool);
        this.addMouseWheelListener(tool);
    }

    public void dissociateTool(AitherTool tool) {
        this.removeMouseListener(tool);
        this.removeMouseMotionListener(tool);
        this.removeMouseWheelListener(tool);
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void resize(double size) {
        if (this.size * size < 1 || this.size * size > 64) {
            return;
        }
        this.size *= size;
    }
}

package view.gui;

import java.awt.Image;

import javax.swing.JPanel;

import model.Game;
import view.celestial_body.ViewStar;

public class MapStellarSystem extends JPanel {
    // CLASS CONSTANTS
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    // INSTANCE VARIABLES
    private Game game;
    private Image background;
    private ViewStar star;
    private int x;
    private int state;

    // CONSTRUCTORS
    public MapStellarSystem(Game game, ViewStar star) {
        this.game = game;

        this.star = star;
        this.x = 0;
        this.state = 0;

        this.setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
        this.setBackground(java.awt.Color.BLACK);

        this.background = new javax.swing.ImageIcon("assets/bg.jpg").getImage();
    }

    // GETTERS

    // SETTERS

    // METHODS
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, 3000*4, 3000*4, this);

        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        g.drawString("Stellar System", 10, 30);

        star.drawSystem((java.awt.Graphics2D) g, x);

        System.out.println(star.getStar().toString());
    }

    public void updateState() {
        state = (state + 1) % 16;
        repaint();
    }
}

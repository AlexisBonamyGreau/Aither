import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.Game;

public class Aither {
    public void Build(String title) throws IOException {
        // CLASS CONSTANTS
        final int WIDTH = 1280;
        final int HEIGHT = 720;

        JFrame frame = new JFrame(title);

        Game game = new Game(frame, WIDTH, HEIGHT);
        game.update();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("assets\\ship\\ship.png").getImage() );
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Aither main = new Aither();
                try {
                    main.Build("Aither");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
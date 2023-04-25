import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.tools.AitherTool;
import view.gui.MapGalaxy;

public class Aither {
    // CLASS CONSTANTS
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    public void Build(String title) throws IOException {

        JFrame frame = new JFrame(title);

        MapGalaxy mapGalaxy = new MapGalaxy(WIDTH, HEIGHT);
        AitherTool aitherTool = new AitherTool();
        mapGalaxy.associateTool(aitherTool);
        frame.add(mapGalaxy);

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
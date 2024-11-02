package enigma;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Objects;

public abstract class AbstractFrame extends JFrame {
    BufferedImage forest;
    private final JMenuItem quitItem = new JMenuItem("Quit");
    String darkforest = "img/woodbg.jpg";

    protected AbstractFrame(String title) {
        super(title);
        this.setFont(new Font("serif", Font.PLAIN,18));
        this.setForeground(new Color(255, 255, 255));
        this.setSize(800,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JMenu optionMenu = new JMenu("Option");
        JMenuBar menu = new JMenuBar();
        menu.add(optionMenu);
        optionMenu.add(quitItem);
        this.setJMenuBar(menu);
        try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch(ClassNotFoundException | InstantiationException | IllegalAccessException |
                    UnsupportedLookAndFeelException ignored){
        }
        try
            {
                forest = ImageIO.read(Objects.requireNonNull(this.getClass().getResource(darkforest)));
                this.setContentPane(new JLabel(new ImageIcon(forest)));
                quitItem.addActionListener(e -> {
                    if (e.getSource() == quitItem) {
                        System.exit(0);
                    }
                });
            }
        catch(
            IOException exp)
            {
                exp.getCause();
            }
            setupFrame();
    }

    protected abstract void setupFrame();

    public void showFrame(){

        this.setVisible(true);
    }
}
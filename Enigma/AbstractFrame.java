package Enigma;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class AbstractFrame extends JFrame {
    BufferedImage forest;
    private JMenu optionMenu = new JMenu("Option");
    private JMenuBar menubar = new JMenuBar();
    private JMenuItem quitItem = new JMenuItem("Quit");
    String darkforest = "img/woodbg.jpg";

    public AbstractFrame(String title) {
        super(title);

        this.

            setSize(800,800);
        this.

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.

            setAlwaysOnTop(true);
        this.

            setResizable(false);
        this.

            setLocationRelativeTo(null);
           menubar.add(optionMenu);
           optionMenu.add(quitItem);
           this.setJMenuBar(menubar);
        try

            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch(ClassNotFoundException |InstantiationException |IllegalAccessException
                 |
            UnsupportedLookAndFeelException ex)

            {
            }

        try

            {
                forest = ImageIO.read(Objects.requireNonNull(this.getClass().getResource(darkforest)));

                this.setContentPane(new JLabel(new ImageIcon(forest)));;

                quitItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == quitItem) {
                            System.exit(0);
                        }
                    }
                });
            }
        catch(
            IOException exp)

            {
                exp.printStackTrace();
            }

            setupFrame();


    }

    protected abstract void setupFrame();

    public void showFrame(){

        this.setVisible(true);
    }
}
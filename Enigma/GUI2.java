package Enigma;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Décrivez votre classe GUI2 ici.
 *
 * @author (205229)
 * @version (16/01/2019)
 **/

public class GUI2 {

    public BufferedImage planet;
    public static guieasy guieasy;
    public static guimed guimed;
    public static guihard guihard;

    public static Easy Easy;
    public static Medium Medium;
    public static Hard Hard;

    private static JButton easy;
    private static JButton medium;
    private static JButton hard;

    private static JMenuBar menubar;

    private static JMenu optionMenu;
    private static Font font;

    private static JMenuItem quitItem;

    private GUI2() {

        Medium = new Medium();
        Hard = new Hard();
        Easy = new Easy();

        easy = new JButton("EASY");
        medium = new JButton("MEDIUM");
        hard = new JButton("HARD");
        font = new Font("serif", Font.PLAIN, 20);

        JFrame frame = new JFrame("Enigma");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel();

        menubar = new JMenuBar();
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");
        String imgstreet = "img/woodbg.jpg";

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException ex) {
                }

                try {
                    // Load the background image
                    planet = ImageIO.read(this.getClass().getResource(imgstreet));

                    panel.add(label);

                    frame.add(panel);

                    frame.setSize(800,800);
                    frame.setLocationRelativeTo(null);
                    frame.setAlwaysOnTop(true);
                    frame.setResizable(false);

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setContentPane(new JLabel(new ImageIcon(planet)));

                    frame.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;

                    easy.setFont(font);
                    frame.add(easy, gbc);
                    medium.setFont(font);
                    frame.add(medium, gbc);
                    hard.setFont(font);
                    frame.add(hard, gbc);
                    frame.add(menubar);
                    frame.setJMenuBar(menubar);
                    menubar.add(optionMenu);
                    optionMenu.add(quitItem);

                } catch (IOException exp) {
                    exp.printStackTrace();
                }

                quitItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == quitItem) {
                            System.out.println("Thank you for playing ! Goodbye");
                            System.exit(0);
                        }

                    }
                });

                easy.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        new guieasy();

                    }
                });

                medium.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        new guimed();
                        frame.setVisible(false);
                    }
                });

                hard.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        new guihard();
                        frame.setVisible(false);
                    }
                });
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void jeu() {
        new GUI2();
    }

}
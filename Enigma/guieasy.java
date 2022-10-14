package Enigma;

import static Enigma.Level.answer;
import static Enigma.Level.player;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Décrivez votre classe guieasy ici.
 *
 * @author (205229)
 * @version (16/01/2019)
 */
public class guieasy {
  
    // private static GUI2 gui2;
    private Level level;
    // private static Hint hint;

    private JButton enter;
    private JButton h;
    private JButton check;
    private JButton back;

    private JPanel pan;
    static JLabel label, hint, question;

    private JMenu optionMenu;
    private JMenuBar menubar;
    private JMenuItem quitItem;

    final JTextField field1, field2;

    private Font font;

    private JFrame frame;

    private BufferedImage darkeasy;

    /**
     * Constructeur d'objets de classe guieasy
     */
    public guieasy() {
        // initialisation des variables d'instance
        level = new Level();
        // hint=new Hint();

        field1 = new JTextField("", 15);
        field2 = new JTextField("", 15);

        enter = new JButton("ENTER");
        back = new JButton("BACK");
        h = new JButton("HINT");
        check = new JButton("CHECK");
        hint = new JLabel("hint", JLabel.HORIZONTAL);
        label = new JLabel("This is a Swing frame", JLabel.HORIZONTAL);
        pan = new JPanel(new GridBagLayout());

        menubar = new JMenuBar();
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");
        String img = "img/woodbg.jpg";

        font = new Font("serif", Font.PLAIN, 20);

        frame = new JFrame("Easy");

        h.setVisible(false);
        check.setVisible(false);
        field2.setVisible(false);

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
                    darkeasy = ImageIO.read(this.getClass().getResource(img));

                    frame.setSize(800,800);                  
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setAlwaysOnTop(true);
                    frame.setResizable(false);

                    // we just loaded
                    frame.setContentPane(new JLabel(new ImageIcon(darkeasy)));
                    // Supply a layout manager for the body of the content
                    frame.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.BELOW_BASELINE;
                    // Add stuff...
                    check.setFont(font);
                    frame.add(check, gbc);
                    h.setFont(font);
                    frame.add(h, gbc);

                    enter.setFont(font);

                    // pan.add(field1,gbc);
                    frame.add(enter, gbc);
                    back.setFont(font);
                    frame.add(back, gbc);

                    gbc.fill = GridBagConstraints.RELATIVE;
                    gbc.gridx = 1;
                    gbc.gridy = 2;
                    pan.add(field1, gbc);
                    // gbc. fill=GridBagConstraints.HORIZONTAL;
                    // gbc.gridx=0;
                    // gbc.gridy=0;
                    pan.add(field2, gbc);
                    // frame.add(field2,gbc);
                    menubar.add(optionMenu);

                    optionMenu.add(quitItem);
                    frame.add(pan);
                    frame.add(menubar);
                    frame.setJMenuBar(menubar);
                    Color color = new Color(255, 255, 255);

                    JTextArea textArea = new JTextArea(
                            Easy.choiceOfEnigma());

                    textArea.setFont(new Font("Serif", Font.PLAIN, 20));
                    textArea.setLineWrap(false);
                    textArea.setWrapStyleWord(true);
                    textArea.setOpaque(false);
                    textArea.setEditable(false);
                    textArea.setForeground(color);
                    pan.add(textArea);
                    frame.add(textArea, gbc);

                    frame.setLocationRelativeTo(null);

                    quitItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == quitItem) {
                                //System.out.println("Thank you for playing.  Good bye.");
                                System.exit(0);
                            }
                        }
                    });

                    /**
                     * Press enter after typing the number in the text field.
                     */

                    enter.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            player = Integer.parseInt(field1.getText());

                            if (player < 1) {
                                System.out.println("Enter a number between 1 and 10");

                            } else if (player > 10) {
                                System.out.println("Enter a number between 1 and 10");
                            } else {
                                textArea.setVisible(false);
                                question = new JLabel(Level.playerAnswer());
                                question.setFont(new Font("Serif", Font.PLAIN, 20));
                                question.setOpaque(false);
                                question.setForeground(color);
                                question.setText("<html><div style=\"width:300px;height:450px;\">"
                                        + Level.playerAnswer() + "</div></html>");
                                frame.add(question, gbc);

                                h.setVisible(true);
                                field2.setVisible(true);
                                check.setVisible(true);
                                enter.setVisible(false);
                                field1.setVisible(false);
                            }
                        }
                    });
                    /**
                     * This button is visible once the question comes up and gives you a hint if you
                     * need it.
                     */
                    h.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == h) {
                                System.out.println(Hint.hint());
                                hint.setText("<html><div style=\"width:100px;height:0px;\">" + Hint.hint()
                                        + "</div></html>");
                                hint.setFont(new Font("Serif", Font.PLAIN, 20));
                                hint.setForeground(color);
                                frame.add(hint, gbc);
                            }

                        }

                    });
                    /**
                     * You go back to the choice of level.
                     */
                    back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Points.point = 0;
                            GUI2.jeu();
                            frame.setVisible(false);

                        }
                    });
                    /**
                     * This button is visible once the question comes up.
                     * It checks if the answer is good or not.
                     */
                    check.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == check) {
                                answer = field2.getText().toLowerCase();

                            }
                            label.setText("<html><div style=\"width:200px;height:450px;\">" + level.goodEasy()
                                    + "</div></html>");
                            label.setFont(new Font("Serif", Font.PLAIN, 20));
                            label.setForeground(color);
                            frame.add(label, gbc);
                        }
                    });
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
        frame.setContentPane(pan);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * private Dimension getPreferredSize() {
     * return darkeasy == null ? pan.getPreferredSize() : new Dimension
     * (darkeasy.getWidth(), darkeasy.getHeight());
     * }
     */
    public static void jeu() {
        new guieasy();
    }
}

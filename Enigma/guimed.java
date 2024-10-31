
package Enigma;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import static Enigma.Level.answer;
import static Enigma.Level.player;

/**
 * Décrivez votre classe guimed ici.
 *
 * @author (205229)
 * @version (16/01/2019)
 */
public class guimed {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    private JButton enter;
    private JButton h;
    private JButton back;
    private JButton check;

    private JPanel pan;

    static JLabel label, hint, question;
    private final JTextField field1, text2;

    private Level level;
    private Font font;

    private JMenu optionMenu;
    private JMenuBar menubar;
    private JMenuItem quitItem;

    private JFrame frame;

    private BufferedImage darkmed;

    public guimed() {

        level = new Level();
        field1 = new JTextField("", 15);
        text2 = new JTextField(15);

        check = new JButton("CHECK");
        enter = new JButton("ENTER");
        back = new JButton("BACK");
        h = new JButton("HINT");

        pan = new JPanel(new GridBagLayout());

        font = new Font("serif", Font.PLAIN, 20);
        hint = new JLabel("hint", JLabel.HORIZONTAL);
        label = new JLabel("This is a Swing frame", JLabel.HORIZONTAL);
        menubar = new JMenuBar();
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");

        frame = new JFrame("Medium");

        check.setVisible(false);

        text2.setVisible(false);

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
                    darkmed = ImageIO.read(this.getClass().getResource("img/woodbg.jpg"));

                    frame.setSize(800, 800);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setAlwaysOnTop(true);
                    frame.setResizable(false);

                    // Set the frames content pane to use a JLabel
                    // whose icon property has been set to use the image
                    // we just loaded
                    frame.setContentPane(new JLabel(new ImageIcon(darkmed)));
                    // Supply a layout manager for the body of the content
                    frame.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.BELOW_BASELINE;
                    // Add stuff...
                    check.setFont(font);
                    frame.add(check, gbc);
                    h.setFont(font);
                    h.setVisible(false);
                    frame.add(h, gbc);

                    enter.setFont(font);
                    frame.add(enter, gbc);
                    back.setFont(font);
                    frame.add(back, gbc);
                    gbc.fill = GridBagConstraints.RELATIVE;
                    gbc.gridx = 1;
                    gbc.gridy = 2;

                    pan.add(text2, gbc);
                    pan.add(field1, gbc);

                    menubar.add(optionMenu);

                    optionMenu.add(quitItem);
                    frame.add(pan);
                    frame.add(menubar);
                    frame.setJMenuBar(menubar);
                    Color color = new Color(255, 255, 255);
                    JTextArea textArea = new JTextArea(
                            Medium.choiceOfEnigma());

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
                               // System.out.println("Thank you for playing. Good bye.");
                                System.exit(0);
                            }
                        }
                    });

                    enter.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            player = Integer.parseInt(field1.getText());

                            if (player <= 10) {
                                System.out.println("Enter a number between 11 and 20 !");

                            } else if (player > 20) {
                                System.out.println("Enter a number between 11 and 20 !");
                            } else {
                                textArea.setVisible(false);
                                question = new JLabel(Level.playerAnswer());
                                question.setFont(new Font("Serif", Font.PLAIN, 20));
                                question.setOpaque(false);
                                question.setForeground(color);
                                question.setText("<html><div style=\"width:300px;height:300px;\">"
                                        + Level.playerAnswer() + "</div></html>");
                                frame.add(question, gbc);

                                h.setVisible(true);
                                text2.setVisible(true);
                                check.setVisible(true);
                                enter.setVisible(false);
                                field1.setVisible(false);
                            }
                        }
                    });

                    h.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == h)
                                System.out.println(Hint.hint());
                            hint.setText(
                                    "<html><div style=\"width:100px;height:0px;\">" + Hint.hint() + "</div></html>");
                            hint.setFont(new Font("Serif", Font.PLAIN, 20));
                            hint.setForeground(color);
                            frame.add(hint, gbc);

                        }
                    });
                    back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            GUI2.jeu();
                            frame.setVisible(false);

                        }
                    });
                    check.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            if (e.getSource() == check) {

                                answer = text2.getText().toLowerCase();

                            }
                            label.setText("<html><div style=\"width:200px;height:300px;\">" + level.goodMedium()
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

    public void jeu() {
        new guimed();
    }
    /**
     * private Dimension getPreferredSize() {
     * return darkmed == null ? pan.getPreferredSize() : new Dimension
     * (darkmed.getWidth(), darkmed.getHeight());
     * }
     */
}

package Enigma;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class GUI extends AbstractFrame {

    public static Main m1=new Main();
    // private static GUI2 gui2;
    // private static Level level;

    private JPanel pan;
    private JMenuBar menubar;
    private JMenu optionMenu;

    private JMenuItem quitItem;


    private BufferedImage forest;
   
    public static void main(String[] args) {
        GUI gui=new GUI();
        gui.showFrame();

    }

    /**
     * Constructeur d'objets de classe GUI
     */
    private GUI() {
        super("Enigma");
            }

    @Override
    protected void setupFrame() {

        Font font= new Font("serif", Font.PLAIN, 20);
        JButton play = new JButton("Play");
        Color color = new Color(255, 255, 255);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JTextArea textArea = new JTextArea(
                m1.intro());
        textArea.setFont(font);
        textArea.setLineWrap(false);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setForeground(color);

        play.addActionListener(e -> GUI2.jeu());
        play.setFont(font);
        // Ajout du panneau au JFrame
        this.add(textArea, gbc);
        this.add(play,gbc);

    }
}
package enigma;

import java.awt.*;
import javax.swing.*;

public class GUI extends AbstractFrame {

    public static void main(String[] args) {
        GUI gui=new GUI();
        gui.showFrame();
    }

    /**
     * Constructeur d'objets de classe GUI
     */
    private GUI() {
        super("enigma");
            }

    @Override
    protected void setupFrame() {
        Main m1=new Main();
        Font font = this.getFont();
        JButton play = new JButton("PLAY");
        Color color = this.getForeground();
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

        play.addActionListener(e -> {
            GUI2.jeu();
            this.setVisible(false);
        });
        play.setFont(font);
        this.add(textArea, gbc);
        this.add(play,gbc);

    }
}
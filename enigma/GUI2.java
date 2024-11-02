package enigma;

import java.awt.*;
import javax.swing.*;


/**
 * Décrivez votre classe GUI2 ici.
 *
 * @author (205229)
 * @version (16 / 01 / 2019)
 **/

public class GUI2 extends AbstractFrame {


    private GUI2 () {
        super("Level");
    }

    public static void jeu () {
        GUI2 gui2 = new GUI2();
        gui2.showFrame();
    }

    @Override
    protected void setupFrame () {
        Font font = this.getFont();
        JButton easy = new JButton("EASY");
        JButton medium = new JButton("MEDIUM");
        JButton hard = new JButton("HARD");
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        easy.addActionListener(e -> {
            this.setVisible(false);
            new guieasy();
        });
        easy.setFont(font);
        add(easy, gbc);

        medium.addActionListener(e -> {
            this.setVisible(false);
            new guimed();
        });
        medium.setFont(font);
        add(medium, gbc);

        hard.addActionListener(e -> {
            this.setVisible(false);
            new guihard();
        });
        hard.setFont(font);
        add(hard, gbc);
    }
}
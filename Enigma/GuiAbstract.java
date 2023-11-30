package Enigma;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GuiAbstract {

    private static Level level;
    private JButton enter;
    private JButton h;
    private JButton back;
    private JButton check;

    private JPanel pan;
    private Hint indice;
    private  JTextField field1, text2;
    static JLabel label, hint, question;
    private JMenu optionMenu;
    private JMenuBar menubar;
    private JMenuItem quitItem;

    private Font font;

    private JFrame frame;

    private BufferedImage darkhard;
    public GuiAbstract() {
        level = new Level();
        hint = new JLabel("hint", JLabel.HORIZONTAL);
        label = new JLabel("This is a Swing frame", JLabel.HORIZONTAL);
        field1 = new JTextField(15);
        text2 = new JTextField(15);
        enter = new JButton("ENTER");
        back = new JButton("BACK");
        h = new JButton("HINT");
        check = new JButton("CHECK");
        indice=new Hint();

        pan = new JPanel(new GridBagLayout());

        menubar = new JMenuBar();
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");

        font = new Font("serif", Font.PLAIN, 20);

        frame = new JFrame("Hard");

        check.setVisible(false);
        text2.setVisible(false);
        h.setVisible(false);
    }
}

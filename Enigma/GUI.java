package Enigma;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	public static Main m1;
   // private static GUI2 gui2;
   // private static Level level;
    
    private JPanel pan;
    private JMenuBar menubar;
    private JMenu optionMenu;
    private JButton play;
    private JFrame frame;
    private JMenuItem quitItem;
    private Font font;
    
    
    private BufferedImage forest;
    

public static void main(String[]args)
{
    new GUI();
    
    }
/**
 * Constructeur d'objets de classe GUI
 */
private GUI()
{
    // initialisation des variables d'instance
    
    //level=new Level();
    m1=new Main();
   // gui2=new GUI2();   
    pan=new JPanel();
    font=new Font("serif",Font.PLAIN,20);
    optionMenu = new JMenu("Option");
    menubar = new JMenuBar();
    quitItem = new JMenuItem("Quit");
    play=new JButton("PLAY");
    frame= new JFrame("Enigma");
    
    String dark_forest="img/dark_forest.png";
    
    
        EventQueue.invokeLater(new Runnable()
        {
                @Override
                public void run(){
                    
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    }

                    try {
                        // Load the background image
                    	forest = ImageIO.read(this.getClass().getResource(dark_forest));

                        // Create the frame...

                        frame.setSize(forest.getWidth(),forest.getHeight());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setAlwaysOnTop(true);
                        frame.setResizable(false);
                        // Set the frames content pane to use a JLabel
                        // whose icon property has been set to use the image
                        // we just loaded                        
                        frame.setContentPane(new JLabel(new ImageIcon(forest)));

                
                        // Supply a layout manager for the body of the content
                        frame.setLayout(new GridBagLayout());
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridwidth = GridBagConstraints.REMAINDER;
                        // Add stuff...
                        
                        play.setFont(font);
                        frame.add(play, gbc);
                       
                        JTextArea textArea = new JTextArea(
                            m1.intro());
                    Color color = new Color(255,255,255);
                    textArea.setFont(new Font("Serif",Font.PLAIN, 16));
                    textArea.setLineWrap(false);
                    textArea.setWrapStyleWord(true);
                    textArea.setOpaque(false);
                    textArea.setEditable(false);
                    textArea.setForeground(color);
                    pan.add(textArea);
                    frame.add(textArea,gbc);
                       
                        menubar.add(optionMenu);

                        optionMenu.add(quitItem);
                        frame.add(menubar);
                        frame.setJMenuBar(menubar);
                        //frame.pack();
                        frame.setLocationRelativeTo(null);
                        //frame.setVisible(true);   

                    } catch (IOException exp) {
                        exp.printStackTrace();
                    }

                    quitItem.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                if(e.getSource()==quitItem)
                                {
                                    System.out.println("Thank you for playing.  Good bye.");
                                    System.exit(0);
                                }
                            }
                        });
                    play.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {

                                GUI2.jeu();
                                
                                frame.setVisible(false);
                            }
                        }); // Finally add the Panel to the Frame and set thinsg visible ...

                }
            });
    
    frame.setContentPane(pan);
    frame.pack();
    frame.setVisible(true);
}


public Dimension getPreferredSize() {
    return forest == null ? pan.getPreferredSize() : new Dimension (forest.getWidth(), forest.getHeight());
}
}
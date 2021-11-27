package Enigma;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import static Enigma.Level.player;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Décrivez votre classe guimed ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class guihard
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static Level l;
    private Hint hint;
    
    private JButton enter;
    private JButton h;
    private JButton back;
    private JButton check;
    
    private JPanel pan;
    
    private final JTextField field1,text2;
    
    private JMenu optionMenu; 
    private JMenuBar menubar ;
    private JMenuItem quitItem;
    
    private Font font;
    
    private JFrame frame;
    
    private BufferedImage darkhard;

    public guihard(){
        l=new Level();
        hint=new Hint();
        
        field1 =new JTextField(15);
        text2=new JTextField(15);
        
        enter=new JButton("ENTER");
        back=new JButton("BACK");
        h=new JButton("HINT");
        check=new JButton("CHECK");
        h=new JButton("HINT");
        
        pan=new JPanel(new GridBagLayout());
        
        menubar=new JMenuBar(); 
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");
        
        font=new Font("serif",Font.PLAIN,20);
        
       
        frame= new JFrame("Hard");
       
        check.setVisible(false);
        text2.setVisible(false);
        h.setVisible(false);
        EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    }
                    try {
                        // Load the background image
                        darkhard = ImageIO.read(this.getClass().getResourceAsStream("img/bghard.jpg"));
                        // Create the frame...
                        frame.setSize(darkhard.getWidth(null),darkhard.getHeight(null));
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setLocationRelativeTo(null);
                        frame.setAlwaysOnTop(true);
                        frame.setResizable(false);

                        // Set the frames content pane to use a JLabel
                        // whose icon property has been set to use the image
                        // we just loaded                        
                        frame.setContentPane(new JLabel(new ImageIcon(darkhard)));
                        // Supply a layout manager for the body of the content
                        frame.setLayout(new GridBagLayout());
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridwidth = GridBagConstraints.REMAINDER;
                        // Add stuff...
                        h.setFont(font);
                        frame.add(h,gbc);
                        //h.setVisible(false);
                        enter.setFont(font);
                        frame.add(enter,gbc);
                        back.setFont(font);
                        frame.add(back,gbc);
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        gbc.gridx = 1;
                        gbc.gridy = 1;
                        pan.add(field1,gbc);
                        // gbc. fill=GridBagConstraints.HORIZONTAL;
                        // gbc.gridx=0;
                        // gbc.gridy=0;
                        pan.add(text2,gbc);
                        pan.add(text2);

                        //setJMenuBar(menubar);     
                        // create the File menu

                        menubar.add(optionMenu);

                        optionMenu.add(quitItem);
                        frame.add(pan);
                        frame.add(menubar);
                        frame.setJMenuBar(menubar);

                        frame.setLocationRelativeTo(null);
                    }   catch (IOException exp) {
                        exp.printStackTrace();
                    }

                    quitItem.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                if(e.getSource()==quitItem){
                                    System.out.println("Thank you for playing.  Good bye.");
                                    System.exit(0);}
                            }
                        });
                    enter.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                player = Integer.parseInt(field1.getText());
                                if(player<=20)
                                {
                                    System.out.println("Enter a number between 21 and 30 !");
                                }
                                else if(player>30)
                                {
                                    System.out.println("Enter a number between 21 and 30 !");
                                }
                                else
                                {
                                                    
                                l.playerAnswer();
                                text2.setVisible(true);
                                check.setVisible(true);
                                h.setVisible(true);
                                enter.setVisible(false);
                                field1.setVisible(false);
                                }
                            }
                        });

                    h.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {

                                System.out.println(hint.hint());

                            }
                        });
                    back.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                GUI2.jeu();
                                frame.setVisible(false);
                                
                            }
                        });

                }
            }); 
        check.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource()==check) 
                        Level.answer=text2.getText();
                    l.good();
                }

            });
        frame.setContentPane(pan);
        frame.pack();
        frame.setVisible(true);
    } 
    public void jeu(){
        new guihard();
    }

    public Dimension getPreferredSize() {
        return darkhard == null ? pan.getPreferredSize() : new Dimension (darkhard.getWidth(), darkhard.getHeight());
    }
}


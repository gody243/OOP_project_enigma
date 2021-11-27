
package Enigma;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import static Enigma.Level.player;
/**
 * Décrivez votre classe guimed ici.
 *
 * @author (205229)
 * @version (16/01/2019)
 */
public class guimed
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
    
    
    private Font font;
    
    private JMenu optionMenu;
    private JMenuBar menubar ;
    private JMenuItem quitItem;
    
    private JFrame frame;
    
    private BufferedImage darkmed;

    public guimed(){
        l=new Level();
        hint=new Hint();
        
        field1 =new JTextField("",15);
        text2=new JTextField(15);
        
        check=new JButton("CHECK"); 
        enter=new JButton("ENTER");
        back=new JButton("BACK");
        h=new JButton("HINT");
        
        pan=new JPanel(new GridBagLayout());
       
        font=new Font("serif",Font.PLAIN,20);
        
        menubar=new JMenuBar();
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");
        
        frame= new JFrame("Medium");
       
      
        check.setVisible(false);
        
        text2.setVisible(false);
    

    
        EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

                    }

                    try {
                        // Load the background image
                        darkmed = ImageIO.read(this.getClass().getResource("img/dark-streetmedium.jpeg"));
                 
                        frame.setSize(darkmed.getWidth(null),darkmed.getHeight(null));
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
                        gbc.gridwidth = GridBagConstraints.REMAINDER;
                        // Add stuff...
                        check.setFont(font);
                        frame.add(check,gbc);
                        h.setFont(font); h.setVisible(false);
                        frame.add(h,gbc);

                        enter.setFont(font);
                        frame.add(enter,gbc);
                        back.setFont(font);
                        frame.add(back,gbc);
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        gbc.gridx = 1;
                        gbc.gridy = 1;
                        // gbc. fill=GridBagConstraints.HORIZONTAL;
                        // gbc.gridx=0;
                        // gbc.gridy=0;
                        pan.add(text2,gbc);
                        pan.add(field1,gbc);

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
                                
                                if(player<=10)
                               {
                                    System.out.println("Enter a number between 11 and 20 !");
                                    
                                }
                                else if(player>20){
                                    System.out.println("Enter a number between 11 and 20 !");
                                }
                                 else{                      
                                l.playerAnswer();                               
                                h.setVisible(true);
                                text2.setVisible(true);
                                check.setVisible(true);
                                enter.setVisible(false);
                                field1.setVisible(false);
                            }
                            }
                        });

                    h.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                if(e.getSource()==h)
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
                    check.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){

                                if(e.getSource()==check) {

                                    Level.answer=text2.getText().toLowerCase();
                                    l.good();
                                }
                            }

                        });

                }
            });    
        frame.setContentPane(pan);
        frame.pack();
        frame.setVisible(true);
    } 
    public void jeu() {
        new guimed ();
    }
/**
    private Dimension getPreferredSize() {
        return darkmed == null ? pan.getPreferredSize() : new Dimension (darkmed.getWidth(), darkmed.getHeight());
    }
    */
}


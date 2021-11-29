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
public class guieasy 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    //private static GUI2 gui2;
    private  Level level;
    //private static Hint hint;
    
    private JButton enter;
    private JButton h;
    private JButton check;
    private JButton back;
   
    
    private JPanel pan;
    
    private JMenu optionMenu;
    private JMenuBar menubar ;
    private JMenuItem quitItem;
    
    final JTextField field1,field2;
    static JTextArea question;
    JTextArea nextQuestion;
    private Font font;
    
    private JFrame frame;
    
    private BufferedImage darkeasy;
    /**
     * Constructeur d'objets de classe guieasy
     */
    public guieasy()
    {
        // initialisation des variables d'instance
        level=new Level();
        //hint=new Hint();
        
        field1 =new JTextField("",15);
        field2 =new JTextField("",15);
        
        enter=new JButton("ENTER");
        back=new JButton("BACK"); 
        h=new JButton("HINT");
        check=new JButton("CHECK");
        h=new JButton("HINT");
        
        pan=new JPanel(new GridBagLayout());
        
        menubar=new JMenuBar(); 
        quitItem = new JMenuItem("Quit");
        optionMenu = new JMenu("Option");
        String img="img/dark-streeteasy.jpeg";
        
        font=new Font("serif",Font.PLAIN,20);
        
       
        frame= new JFrame("Easy");
        
        h.setVisible(false);
        check.setVisible(false);
        field2.setVisible(false);

        EventQueue.invokeLater(new Runnable(){
                @Override
                public void run()
                {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    }
                    try {
                        // Load the background image
                        darkeasy = ImageIO.read(this.getClass().getResource(img));

                        
                        frame.setSize(darkeasy.getWidth(null),darkeasy.getHeight(null));
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setLocationRelativeTo(null);
                        frame.setAlwaysOnTop(true);
                        frame.setResizable(false);
                       
                        // we just loaded                        
                        frame.setContentPane(new JLabel(new ImageIcon(darkeasy)));
                        // Supply a layout manager for the body of the content
                        frame.setLayout(new GridBagLayout());
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridwidth = GridBagConstraints.SOUTH;
                        // Add stuff...
                        check.setFont(font);
                        frame.add(check,gbc);
                        h.setFont(font);
                        frame.add(h,gbc);
                        //h.setEnabled(false);
                        enter.setFont(font);

                        //pan.add(field1,gbc);
                        frame.add(enter,gbc);
                        back.setFont(font);
                        frame.add(back,gbc);

                        gbc.fill = GridBagConstraints.RELATIVE;
                        gbc.gridx = 1;
                        gbc.gridy = 2;
                        pan.add(field1,gbc);
                        // gbc. fill=GridBagConstraints.HORIZONTAL;
                        // gbc.gridx=0;
                        // gbc.gridy=0;
                        pan.add(field2,gbc);
                        //frame.add(field2,gbc);
                        menubar.add(optionMenu);

                        optionMenu.add(quitItem);
                        frame.add(pan);
                        frame.add(menubar);
                        frame.setJMenuBar(menubar);
                        Color color = new Color(255,255,255);
                        
                        JTextArea textArea = new JTextArea(
                    Easy.choiceOfEnigma());
                    
                    textArea.setFont(new Font("Serif",Font.PLAIN, 20));
                    textArea.setLineWrap(false);
                    textArea.setWrapStyleWord(true);
                    textArea.setOpaque(false);
                    textArea.setEditable(false);
                    textArea.setForeground(color);
                    pan.add(textArea);
                    frame.add(textArea,gbc);

                        frame.setLocationRelativeTo(null);
                   
                    
                    quitItem.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                if(e.getSource()==quitItem){
                                    System.out.println("Thank you for playing.  Good bye.");
                                    System.exit(0);
                                }
                            }
                        }
                       );
                        
                        /**
                         * Press enter after typing the number in the text field.
                         */
                    
                    enter.addActionListener(new ActionListener()
                    {
                            public void actionPerformed(ActionEvent e)
                            {                                
                                player = Integer.parseInt(field1.getText());
                                                                                               
                                if(player<1)
                               {
                                    System.out.println("Enter a number between 1 and 10");
                                    
                                   
                               } 
                               else if(player>10){
                                    System.out.println("Enter a number between 1 and 10");
                               }
                               else{     
                                textArea.setVisible(false);
                                question= new JTextArea(Level.playerAnswer());
                                question.setFont(new Font("Serif",Font.PLAIN, 20));
                                question.setLineWrap(false);
                                question.setWrapStyleWord(true);
                                question.setOpaque(false);
                                question.setEditable(false);
                                question.setForeground(color);
                                
                                frame.add(question,gbc);  
                                                             
                                h.setVisible(true);
                                field2.setVisible(true);
                                check.setVisible(true);
                                enter.setVisible(false);
                                field1.setVisible(false) ; 
                               }                          
                            }
                        });
                        /**
                         * This button is visible once the question comes up and gives you a hint if you need it.
                         */
                    h.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                if (e.getSource()==h)
                                frame.add(new JTextArea(Hint.hint()),gbc);
                                System.out.println(Hint.hint());
                            }
                        });
                        /**
                         * You go back to the choice of level.
                         */
                    back.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e)
                            {
                                Points.point=0;
                                GUI2.jeu();
                                frame.setVisible(false);
                                
                            }
                        });
                        /**
                         * This button is visible once the question comes up.
                         * It checks if the answer is good or not.
                         */
                    check.addActionListener(new ActionListener()
                    {
                            public void actionPerformed(ActionEvent e)
                            {
                                
                                if(e.getSource()==check) {
                                    answer=field2.getText().toLowerCase();
                                   
                                }
                                 
                                nextQuestion=new JTextArea(level.good());

                                nextQuestion.setFont(new Font("Serif",Font.PLAIN, 20));
                                nextQuestion.setLineWrap(false);
                                nextQuestion.setWrapStyleWord(true);
                                nextQuestion.setOpaque(false);
                                nextQuestion.setEditable(false);
                                nextQuestion.setForeground(color);  
                                //question.replaceRange(nextQuestion.toString(),0,nextQuestion.toString().length());                              
                                frame.add(nextQuestion,gbc);

                            }
                        });
                    }   catch (IOException exp) {
                        exp.printStackTrace();
                    }
                }
            });   
        frame.setContentPane(pan);
        frame.pack();
        frame.setVisible(true);
    } 
/**
    private Dimension getPreferredSize() {
        return darkeasy == null ? pan.getPreferredSize() : new Dimension (darkeasy.getWidth(), darkeasy.getHeight());
    }
    */
    public static void jeu(){
        new guieasy();
    }
}

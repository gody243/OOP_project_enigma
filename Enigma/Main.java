package Enigma;

import java.util.*;

/**
 * This is Main class where the player can start the game of enigma.
 *
 * @author (205229)
 * @version (a version number 21/11/2018)
 */
public class Main {
    Scanner sc;
    // private String name;
    // private Level currentLevel;

    /**
     * Initializing the currentLevel from the Level class
     */
    public Main() {

        // currentLevel=new Level();
        sc = new Scanner(System.in);

    }

    /**
     * This is an introduction to the game
     * 
     * @param no parameter
     * @return no return
     */

    public String intro() {
        String intro = "Hello Godefroy let's debug that and make this game work !\nIn this game you'll have to solve my riddles.\nThere are 3 levels and 10 questions in each of them."
                + "\nTry to solve all my riddles and you'll be the Great Master!!\nClick on PLAY !";
        return intro;
    }

    /**
     * In this method we call the function start(), to start the game and also the
     * method level() from the Level class
     * 
     * @param no parameter
     * @return no return
     */
    /**
     * public void play()
     * {
     * 
     * Start();
     * boolean finished = false;
     * while (! finished ) {
     * 
     * if(Points.point==150 && currentLevel.player==30)
     * {System.out.println("Congratulations\n You are now the Great Master!");
     * finished=true;
     * }
     * }
     * 
     * }
     */

}

package Enigma;

//import java.util.*;
/**
 * This is the level of difficulty Easy where all the easy questions are
 * 
 * @author (205229)
 * @version (16/01/2019)
 */
public class Hard {
    String h;

    public Hard() {
        choiceOfEnigma();
    }

    /**
     * This method enables the player to start with any question he wants
     * 
     * @aram no parameter
     * @return no return
     */
    public static String choiceOfEnigma() {
        String h = "Choose your enigma (number) : \n21:Divide\n22:Say What ?\n23:Sticks\n24:Bags\n25:Sommelier\n26:The Painting\n27:Between 2\n28:Towel\n29:Teeth\n30:From nothing";

        return h;
    }

    public void choice() {
        System.out.println(h);
    }
}

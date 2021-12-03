package Enigma;

//import java.util.*;
/**
 * This is the level of difficulty Medium where all the easy questions are
 * 
 * @author (205229)
 * @version (a version number 21/11/2018)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Medium {
    String m;

    public Medium() {
        choiceOfEnigma();
    }

    /**
     * This method enables the player to start with the question he wants
     * 
     * @aram no parameter
     * @return no return
     */
    public static String choiceOfEnigma() {
        String m = "Choose your enigma (number) : \n11:Hens\n12:Sphinx\n13:Logic\n14:Missing Numbers\n15:Cats\n16:Savant Calcul\n17:Ehhh\n18:Portrait\n19:Long\n20:Hello";

        return m;
    }

    public void choice() {
        System.out.println(m);
    }
}

package Enigma;

import java.util.*;
/**
 * Décrivez votre classe Hint ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Hint 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    
    public static  LinkedHashMap <Integer,String> hint;
    /**
     * The constructor initializes the Hashmap Hint
     */
    public Hint()
    {
        // initialisation des variables d'instance
        hint=new LinkedHashMap<Integer,String>();
        easyH();
        mediumH();
        hardH();
    }
    private void easyH()
    {
       
        hint.put(1,"Try to answer each sentence seperately.");
        hint.put(2,"Time goes during this sequence. ");
        hint.put(3,"How many do we need at least ?");
        hint.put(4,"At what moment will you take the first pill ?");
        hint.put(5,"Be careful of the proportionnality.");
        hint.put(6,"Be careful of the oversight.");
        hint.put(7,"What is the essential element to see your reflect in a mirror ?");
        hint.put(8,"No need of a calculator.");
        hint.put(9,"Rifle's effect.");
        hint.put(10,"Read it carefully.");
    }
    private void mediumH()
    {
        
        hint.put(11,"Half less of hens for half less time.");
        hint.put(12,"Growing old may vary some data.");
        hint.put(13,"You should distinctly read the numbers.");
        hint.put(14,"Search for all the paths.");
        hint.put(15,"Not that many.");
        hint.put(16,"Have you read everything from the beginning ?");
        hint.put(17,"You hear it quite often.");
        hint.put(18,"A direct family relationship.");
        hint.put(19,"This continuation represents a duration.");
        hint.put(20,"The same.");
    }
    private void hardH()
    {
        
        hint.put(21,"It is not an integer.");
        hint.put(22,"In order to facilitate the solution,you should use a piece of paper and write the hypothesis one after another.");
        hint.put(23,"Start with 2 sticks to evaluate the best move then add sticks ");
        hint.put(24,"A wheat bag weighs=3/4 of a wheat bag +2 kilos ");
        hint.put(25,"Test all the possibilities.");
        hint.put(26,"The fractions can help you.");
        hint.put(27,"Read it carefully.");
        hint.put(8,"I am an object.");
        hint.put(29,"You use it everyday(I hope so)");
        hint.put(30,"The answer is neutral.");
    }
    public static String hint()
    {
       if(hint.containsKey(Level.player)){
           return hint.get(Level.player);}
           else{
               System.out.println("error");
            }
    return hint.get(Level.player);
    }
}

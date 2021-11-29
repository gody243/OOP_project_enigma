package Enigma;

import java.util.*;
/**
 * Décrivez votre classe Solutions ici.
 *
 * @author (205229)
 * @version (16/01/2019)
 */
public class Solutions 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public LinkedHashMap<Integer,String>solutions;
   

    /**
     *  The constructor initializes the Hashmap solutions
     */
    public Solutions()
    {
        // initialisation des variables d'instance
        solutions=new LinkedHashMap<Integer,String>();
       
        easyS();
        mediumS();
        hardS();
    }

    /**
     * answers of each question classified
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    private void easyS()
    {
        // Insérez votre code ici
       solutions.put(1,"nothing");
       solutions.put(2,"a");
       solutions.put(3,"3");
       solutions.put(4,"60");
       solutions.put(5,"95");
       solutions.put(6,"20");
       solutions.put(7,"0");        
       solutions.put(8,"0");
       solutions.put(9,"0");
       solutions.put(10,"0");
    }
    private void mediumS()
    {
        solutions.put(11,"250");
        solutions.put(12,"man");
        solutions.put(13,"13112221");
        solutions.put(14,"35");
        solutions.put(15,"3");
        solutions.put(16,"2");
        solutions.put(17,"name");
        solutions.put(18,"son");
        solutions.put(19,"9s");
        solutions.put(20,"equal");
    }
    private void hardS()
    {
         solutions.put(21,"0.5");
         solutions.put(22,"german");
         solutions.put(23,"2");
         solutions.put(24,"6");
         solutions.put(25,"9");
         solutions.put(26,"40");
         solutions.put(27,"and");
         solutions.put(28,"towel");
         solutions.put(29,"comb");
         solutions.put(30,"0");
    }
    
}

package enigma;

import java.util.*;


public class Solutions {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    protected Map<Integer, String> solution= new LinkedHashMap<>();

    
    public Solutions() {
        // initialisation des variables d'instance

        easyS();
        mediumS();
        hardS();
    }

    
    private void easyS() {
        // Insérez votre code ici
        solution.put(1, "nothing");
        solution.put(2, "a");
        solution.put(3, "3");
        solution.put(4, "60");
        solution.put(5, "95");
        solution.put(6, "20");
        solution.put(7, "0");
        solution.put(8, "0");
        solution.put(9, "0");
        solution.put(10, "0");
    }

    private void mediumS() {
        solution.put(11, "250");
        solution.put(12, "man");
        solution.put(13, "13112221");
        solution.put(14, "35");
        solution.put(15, "3");
        solution.put(16, "2");
        solution.put(17, "name");
        solution.put(18, "son");
        solution.put(19, "9s");
        solution.put(20, "equal");
    }

    private void hardS() {
        solution.put(21, "0.5");
        solution.put(22, "echo");
        solution.put(23, "2");
        solution.put(24, "6");
        solution.put(25, "candle");
        solution.put(26, "40");
        solution.put(27, "and");
        solution.put(28, "towel");
        solution.put(29, "comb");
        solution.put(30, "0");
    }

}

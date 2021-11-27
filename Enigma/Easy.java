package Enigma;

    //import java.util.*;
   /**
    * This is the level of difficulty Easy  where all the easy questions are
    * @author (205229)
    * @version (a version number 21/11/2018)
    */
    public class Easy {
        private String e;
        
        public Easy(){
         choiceOfEnigma();
        }
        
        /**
         * This method just prints the enigmas of Easy
         * @aram no parameter
        * @return no return 
         */
        public String choiceOfEnigma(){
           e="Choose your enigma (number) : \n1:Standford\n2:Letter\n3:Ducks\n4:Prescription\n5:Lil Brother\n6:Number9\n7:The_Room\n8:Apple tree\n9:Birds\n10:Deluge\nEasy >";
           return e;
        }
        
        public void choice(){
            System.out.println(e);
    }
}

    
    




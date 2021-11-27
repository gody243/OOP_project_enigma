package Enigma;

import java.util.*;
/**
 * The Level class has a role of mediator between the Main class and the level classes
 * its role is to manage to cohesion between the level classes.
 *
 * @author (205229)
 * @version (a version number or a date)
 */
public class Level extends Questions 
{
    // instance variables - replace the example below with your own
    Scanner sc=new Scanner(System.in);
    public static int player;
    public static String answer;
    Easy e;
    Medium m;
    Hard h;
    Points point;
    Hint hint;

    /**
     *Initializing the 3 levels
     */
    public Level(){
        hint=new Hint();
        point=new Points();
        e=new Easy();
        m=new Medium();
        h=new Hard();
    }

    /**
     * In this method the player chooses which level he wants to play,this is the method called in the main class
     * @param no parameter
     * @return no return
     */
    public void level(){
        System.out.println("Choose your level :\teasy\t\tmedium\t\thard");
        answer=sc.next();
        while(!(answer.equals("easy")||answer.equals("medium")||answer.equals("hard"))){
            System.out.println("Invalid");
            System.out.println("Choose your level :\teasy\t\tmedium\t\thard");
            answer=sc.next();
        }

        switch (answer){
            case "easy": 
            e.choice();
            while(!(player==1||player==2||player==3||player==4||player==5||player==6||player==7||player==8||player==9||player==10)){
                //System.out.println("Invalid");
                player=sc.nextInt(); 
                playerAnswer();
            }     
            player=sc.nextInt();
            break;
            case "medium":
            m.choice();
            while(!(player==11||player==12||player==13||player==14||player==15||player==16||player==17||player==18||player==19||player==20)){
                //System.out.println("Invalid");
                player=sc.nextInt(); 
                playerAnswer();
            }  
            break;
            case "hard":
            h.choice();
            while(!(player==21||player==22||player==23||player==24||player==25||player==26||player==27||player==28||player==29||player==30)){
                //System.out.println("Invalid");
                player=sc.nextInt(); 
                playerAnswer();
            }  
            break;
        }

    }

    /**
     * This method is not yet used but allows the player to go to the previous question
     *@param no parameter
     *@return no return 
     */
    /**   
    private void previousEnigma(){
        System.out.println("Previous Enigma :");
        player--;
        playerAnswer();
    }
    */

    /**
     *When the choice of enigma is made, this method shows the question that the player wants to answer to 
     *@param no parameter
     *@return string
     */

    public String playerAnswer(){
        if(questions.containsKey(player)){
            System.out.println(questions.get(player));
        }
        else{
            System.out.println("error");
        }

        
        return "playerAnswer() TEST RETURN STRING";
    }

    /**
     * This methods checks whether the player has the correct answer or not. If he does not, he can try again
     *@param no parameter
     * @return the next enigma 
     */
    /**
    private String goodAnswer(){

        boolean good_ans=false;
        
         answer=sc.next();
        
        while(!solutions.get(player).equals(answer)){
            System.out.println("Incorrect !\nTry again");
            System.out.println("HINT:"+ hint.hint());
            answer=sc.next();
        }
        
      
            //assertion - the answer is correct when this line is reached.
            good_ans=true;
            Points.point=Points.point+5;
            System.out.println("Correct !\tScore :"+Points.point);
        return nextEnigma();
    }
    */
    /**
     * Same method as above except there is no while loop and it is for GUI
     * @return String
     */
    public String good(){

        //boolean good_ans=false;
        
        if(solutions.get(player).equals(answer)){
            //good_ans=true;
            Points.point=Points.point+5;
            System.out.println("Correct !\tScore :"+Points.point);
            return nextEnigma();
            
        }
        else{
            System.out.println("Incorrect !\nTry again");
        }
        return "test";
    }

    /**
     * After a good answer, the next question comes up automatically
     *@param no parameter
     *@return no return 
     */
    private String nextEnigma(){
        System.out.println("Next enigma :");
        if(player>=30){
            System.out.println("We're done here");
            System.exit(0);
        }
        player++;
        return playerAnswer();
    }

}


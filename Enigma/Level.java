package Enigma;

import java.util.*;

/**
 * The Level class has a role of mediator between the Main class and the level
 * classes
 * its role is to manage to cohesion between the level classes.
 *
 * @author (205229)
 * @version (a version number or a date)
 */
public class Level extends Questions {
    // instance variables - replace the example below with your own
    Scanner sc = new Scanner(System.in);


    public int getPlayer() {
        return player;
    }

    protected void setPlayer(int player) {
        this.player = player;
    }



    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public  int player;
    public  String answer;
    Easy e;
    Medium m;
    Hard h;
    Points point;


    /**
     * Initializing the 3 levels
     */
    public Level() {

        point = new Points();
        e = new Easy();
        m = new Medium();
        h = new Hard();
    }

    /**
     * In this method the player chooses which level he wants to play,this is the
     * method called in the main class

     *
     */
    public void level() {
        System.out.println("Choose your level :\teasy\t\tmedium\t\thard");
        answer = sc.next();
        while (!(answer.equals("easy") || answer.equals("medium") || answer.equals("hard"))) {
            System.out.println("Invalid");
            System.out.println("Choose your level :\teasy\t\tmedium\t\thard");
            answer = sc.next();
        }

        switch (answer) {
            case "easy":
                e.choiceOfEnigma();
                while (player >= 1 && player <= 10) {
                    player = sc.nextInt();
                    playerAnswer();
                }
                player = sc.nextInt();
                break;
            case "medium":
                m.choiceOfEnigma();
                while (player >= 11 && player <= 20) {
                    player = sc.nextInt();
                    playerAnswer();
                }
                break;
            case "hard":
                h.choiceOfEnigma();
                while (player >= 21 && player <= 30) {
                    player = sc.nextInt();
                    playerAnswer();
                }
                break;
        }

    }

    /*
     * This method is not yet used but allows the player to go to the previous
     * question
     *
     * @param no parameter
     * @return no return
     *
     */
     /* private void previousEnigma(){
     * System.out.println("Previous Enigma :");
     * player--;
     * playerAnswer();
     * }
     */

    /**
     * When the choice of enigma is made, this method shows the question that the
     * player wants to answer to

     * @return the question
     */

    public  String playerAnswer() {
        return questions.getOrDefault(player, "This is not a valid number!");
    }

    /**
     * Same method as above except there is no" while loop" and it is for GUI
     * 
     * @return String
     */
    public String goodEasy() {

        if (solutions.get(player).equals(answer)) {
            point.setPoint(5);
            guieasy.question.setVisible(false);
            return nextEnigma() + "\nScore : " + point.getPoint();
        } else {
            guieasy.question.setVisible(false);
            return "Incorrect! Try again " + questions.get(player) + " Score : " + point.getPoint();
        }
    }


    public String goodMedium() {

        if (solutions.get(player).equals(answer)) {
            point.setPoint(5);
            guimed.question.setVisible(false);
            return nextEnigma() + "\nScore : " + point.getPoint();
        } else {
            guimed.question.setVisible(false);
            return "Incorrect! Try again " + questions.get(player) + " Score : " + point.getPoint();
        }
    }

    public String goodHard() {

        if (solutions.get(player).equals(answer)) {
            point.setPoint(5);
            guihard.question.setVisible(false);
            return nextEnigma() + "\nScore : " + point.getPoint();
        } else {
            guihard.question.setVisible(false);
            return "Incorrect ! Try again " + questions.get(player) + " Score : " +point.getPoint();
        }
    }

    /**
     * After a good answer, the next question comes up automatically

     * @return returns the next question
     */
    public String nextEnigma() {

        if (player >= 30) {
             System.exit(0);
        }
        player++;
        return questions.get(player);
    }

}

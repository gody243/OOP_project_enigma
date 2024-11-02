package enigma;

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
    public static int player;
    public static String answer;
    Easy e;
    Medium m;
    Hard h;
    Points point;
    Hint hint;

    /**
     * Initializing the 3 levels
     */
    public Level() {
        hint = new Hint();
       // point = new Points();
        e = new Easy();
        m = new Medium();
        h = new Hard();
    }

    /**
     * In this method the player chooses which level he wants to play,this is the
     * method called in the main class
     * 
     * @param no parameter
     * @return no return
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
                e.choice();
                while (!(player < 1 || player > 10)) {
                    player = sc.nextInt();
                    playerAnswer();
                }
                player = sc.nextInt();
                break;
            case "medium":
                m.choice();
                while (!(player < 11|| player > 20)) {
                    player = sc.nextInt();
                    playerAnswer();
                }
                break;
            case "hard":
                h.choice();
                while (!(player < 21 || player > 30)) {
                    player = sc.nextInt();
                    playerAnswer();
                }
                break;
        }

    }
    public static String playerAnswer() {
        return questions.getOrDefault(player, "This is not a valid number!");
    }

    public String goodEasy() {

        if (solutions.get(player).equals(answer)) {
            Points.point = Points.point + 5;
            System.out.println("Correct\nScore: " + Points.point);
            //guieasy.question.setVisible(false);
            return nextEnigma() + "\n\nScore : " + Points.point;
        } else {
            System.out.println("Incorrect !\nTry again");
            guieasy.question.setVisible(false);
            return "Incorrect! Try again" + questions.get(player) + "\n Score : " + Points.point;
        }
    }

    public String goodMedium() {

        if (solutions.get(player).equals(answer)) {
            Points.point = Points.point + 5;
            System.out.println("Correct\nScore: " + Points.point);
            //guimed.question.setVisible(false);
            return nextEnigma() + "\nScore : " + Points.point;
        } else {
            System.out.println("Incorrect !\nTry again");
            guimed.question.setVisible(false);
            return "Incorrect! Try again " + questions.get(player) + " Score : " + Points.point;
        }
    }

    public String goodHard() {

        if (solutions.get(player).equals(answer)) {
            Points.point = Points.point + 5;
            System.out.println("Correct\nScore: " + Points.point);
            //guihard.question.setVisible(false);
            return nextEnigma() + "\nScore : " + Points.point;
        } else {
            System.out.println("Incorrect !\nTry again");
            guihard.question.setVisible(false);
            return "Incorrect ! Try again " + questions.get(player) + " Score : " + Points.point;
        }
    }

    /**
     * After a good answer, the next question comes up automatically
     * 
     * @param no parameter
     * @return returns the next question
     */
    public String nextEnigma() {
        System.out.println("Next enigma :");
        if (player >= 30) {
            System.out.println("We're done here");
            System.exit(0);
        }
        player++;
        System.out.println(questions.get(player));
        return questions.get(player);
    }

}

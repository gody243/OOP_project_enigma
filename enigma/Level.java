package enigma;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.*;

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
    Scanner sc = new Scanner(in);
    public static int player;
    protected static String answer;
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
        e = new Easy();
        m = new Medium();
        h = new Hard();
    }


    public void level() {

        answer = sc.next();
        while (!(answer.equals("easy") || answer.equals("medium") || answer.equals("hard"))) {
            answer = sc.next();
        }

        switch (answer) {
            case "easy" -> {
                e.choice();
                while (!(player < 1 || player > 10)) {
                    player = sc.nextInt();
                    playerAnswer();
                    break;
                }
                player = sc.nextInt();

            }
            case "medium" -> {
                m.choice();
                while (!(player < 11 || player > 20)) {
                    player = sc.nextInt();
                    playerAnswer();
                    break;
                }
            }
            case "hard" -> {
                h.choice();
                while (!(player < 21 || player > 30)) {
                    player = sc.nextInt();
                    playerAnswer();
                    break;
                }
            }

            default -> out.println("Invalid input. Please enter 'easy','medium' or 'hard'.");
        }

    }
    public static String playerAnswer() {
        return question.getOrDefault(player, "This is not a valid number!");
    }

    public String goodEasy() {

        if (solution.get(player).equals(answer)) {
            Points.setPoint(Points.getPoint() + 5);
            out.println("Correct\nScore: " + Points.getPoint());
            return nextEnigma() + "\n\nScore : " + Points.getPoint();
        } else {
            guieasy.question.setVisible(false);
            return "Incorrect! Try again" + question.get(player) + "\n Score : " + Points.getPoint();
        }
    }

    public String goodMedium() {

        if (solution.get(player).equals(answer)) {
            Points.setPoint(Points.getPoint() + 5);
            out.println("Correct\nScore: " + Points.getPoint());
            return nextEnigma() + "\nScore : " + Points.getPoint();
        } else { 
            guimed.question.setVisible(false);
            return "Incorrect! Try again " + question.get(player) + " Score : " + Points.getPoint();
        }
    }

    public String goodHard() {

        if (solution.get(player).equals(answer)) {
            Points.setPoint(Points.getPoint() + 5);
            out.println("Correct\nScore: " + Points.getPoint());
            return nextEnigma() + "\nScore : " + Points.getPoint();
        } else {
            guihard.question.setVisible(false);
            return "Incorrect ! Try again " + question.get(player) + " Score : " + Points.getPoint();
        }
    }
//    public String goodAnswer() {
//        if (solutions.get(player).equals(answer)) {
//              Points.setPoint(Points.getPoint() + 5);
//            return nextEnigma() + "\n\nScore : " + Points.getPoint();
//
//        } else {
//
//            if (IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).anyMatch(i -> solutions.containsKey(i))) {
//                guieasy.question.setVisible(false);
//            }
//            if (IntStream.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20).anyMatch(i -> solutions.containsKey(i))) {
//                guimed.question.setVisible(false);
//            }
//             if (IntStream.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30).anyMatch(i -> solutions.containsKey(i))) {
//                guihard.question.setVisible(false);
//            }
//
//            return "Incorrect Try again " + questions.get(player);
//
//        }
//
//    }


    public String nextEnigma() {

        if (player >= 30) {
            exit(0);
        }
        player++;

        return question.get(player);
    }

}

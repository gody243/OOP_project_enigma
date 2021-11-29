package Enigma;

import java.util.*;
/**
 * Décrivez votre classe Questions ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public  class Questions extends Solutions 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public static LinkedHashMap <Integer, String>questions;

    /**
     * The constructor initializes the Hashmap questions
     */
    public Questions()
    {
        // initialisation des variables d'instance
        questions=new LinkedHashMap<Integer,String>();

        easyQ();
        mediumQ();
        hardQ();
    }

    /**
     * This method creates all the easy questions for the hashmap of enigma  we have the number of the question so we can have an order.
     * @param no parameter
     * @return no return 
     */
    private void easyQ()
    {
        // Insérez votre code ici

        questions.put(1,"What's greater than GOD, \nMore evil than the devil,\nThe poor have it,\nThe rich need it,\nAnd if you eat it, you'll die");
        questions.put(2,"What's the following letter:\nj-f-m-a-m-j-j-?");
        questions.put(3,"2 ducks are in front of 1 duck,\n2 ducks are behind 1 duck and\n1 duck is in the middle.\nHow many ducks are there?");
        questions.put(4,"Your doctor gave you a treatment\nof 3 capsules.\nYou have to take one every half hours.\nWhat is the duration of\nthe treatment(in minutes)?");
        questions.put(5,"David is 10 years old,\nhis little brother Franck is half his age.\nWhen David is going to be 10 times more aged,\nWhat will be the age of Franck?");
        questions.put(6,"How many times\ndo we find the number 9\nin the series of numbers from 1 to 100?");
        questions.put(7,"In a square room,the walls,\nthe ceiling and the floor are huge mirrors.\nIf you were in that room,\nHow many reflects of yourself would you see ?");
        questions.put(8,"An apple tree has 9 principal branches.\nOn each principal branch\nthere are 9 important branches."
            +"\nOn each important branch\nthere are 9 normal branches.\nOn each normal branch\nthere are 9 little branches."
            +"\nOn each little branch\nthere are 9 very little branches.\nOn each very little branch\nthere are minuscule branches."
            +"\nOn each minuscule branch\nthere are 9 fruits.\nHow many cherries are there in total?");
        questions.put(9,"10 birds are on a tree\nA hunter comes up and shoot with his\nrifle on one and kills him.\nHow many birds are left on the tree ?");
        questions.put(10,"How many animals of each species did\nMoses take with him on his arck ?");

    }

    /**
     * This method creates all the medium questions for the hashmap of enigma  we have the number of the question so we can have an order.
     * @param no parameter
     * @return no return 
     */
    private void mediumQ()
    {

        questions.put(11,"1000 hens lay 1000 eggs in 10 days.\nHow many  would 500 hens lay in 5 days?(We suppose they don't make 10 days to lay an egg)");
        questions.put(12,"What walks on four legs in the morning, two in the afternoon and three at night?");
        questions.put(13,"Find what seems to be the logical result :\n1\n1 1\n2 1\n1 2 1 1\n1 1 1 2 2 1\n3 1 2 2 1 1");
        questions.put(14,"Find the missing number :\n14 25 53 44 67\n74 63 ?? 44 21");
        questions.put(15,"3 cats catch 3 mice in 3 minutes.\nHow many do you need to catch 60 mice in 60 minutes?");
        questions.put(16,"2=6\n3=36\n4=436\n5=5436\n6=?");
        questions.put(17,"What belongs to me but that others use more than me ?");
        questions.put(18,"A man is looking at a portrait.Someone asks him: Who are you looking at?,he says:\nI have no brother or sister,but this man's father is my father's son.\nWho is on that portrait?");
        questions.put(19,"Find the missing part of the following:\t1j-2f-3m-4a-5m-6j-7j-8a-'?'-10o-11n-12d");
        questions.put(20,"Loved by mathematicians,GOD never met it,the king sometimes and the farmer always\nWhat is it ? ");
    }

    /**
     * This method creates all the hard questions for the hashmap of enigma  we have the number of the question so we can have an order.
     * @param no parameter
     * @return no return 
     */
    private void hardQ()
    {

        questions.put(21,"What number divided by itself gives its double?");
        questions.put(22,"This enigma would had been proposed by Albert Einstein.According to him,only 2% of the population would be able to solve this enigma.\n5people of different nationalities:"
            +"\nlive 5 houses lined up of distinct colors"
            +"\nsmoke cigars of different brands(Rothman,Dunhill,Prince,Pall Mall,Blue Master)"
            +"\ndrink 5 differents drinks(tea,milk,beer,water,coffee)"
            +"\nraise 5 animals of different species."
            +"\nWho's got fish?"
            +"\nHypothesis :"
            +"\nThe norwegian lives in the 1st house\nThe english man lives in the red house\nThe green house is located on the white house's left\nThe danish man drinks tea"
            +"\nThe one who smokes Rothmans lives next to the one who raises cats\nThe person who lives in the yellow house smokes Dunhills\nThe German smokes Princes"
            +"\nThe person who lives in the middle drinks milk\nThe one who smokes Rothmans has a neighbour who drinks water\nThe personwho smokes Pall Malls raises birds"
            +"\nThe person who raises horses lives next to the yellow house\nThe person who smokes Blue Masters drinks beer\nIn the green house,we drink coffee.");
        questions.put(23,"Eva and Chloe have at their disposal 11 sticks.\nThey want to play a game where the loser will be the one who takes the last stick.Each round,they can take 1,2 or 3."
            +"\nKnowing that they are both playing perfectly and that Eva is starting,how many sticks will she take in the first roundto be sure that she is going to win the game?");
        questions.put(24,"A wheat bag weighs the three quarters of a barley bag  which weighs 2kg more than a wheat bag.\nWhat is the weight of a wheat bag ?");
        questions.put(25,"A man meets his neighbor and learns that she's got 3 daughters.\tIntrigued,he asks their ages,but she wanted to answer indirectly with this riddle :\tNeighbor:The product of their ages is 36."
            +"\tMan:I would need more information\tN:The sum is equal to the house number facing us.\tM:I still cannot find it.\tThe oldest is blond\tOh alright I see.\tHow old is the oldest ?");
        questions.put(26,"Christelle needs someone to paint her wall,she knows 3 people who could do it.\nFranck can paint a wall in 1 hour,"
            +"\nJack in 3 hours and Leon in 6 hours.She is in the rush and hire them 3.\nHow long is it going to take for the 3 of them to paint this wall ?(in minutes)");
        questions.put(27,"I am between 188 and 189,but I am Not 189.\nWho am I ?");
        questions.put(28,"When I dry,I get wet.\nWho am I ?");
        questions.put(29,"It has got teeth but does Not bite,What is it ?");
        questions.put(30,"I have neither beginning nor end,\n9 sisters escort and help me,\nAlone I am worthless,\nBut when they precede me,"
            +"\nwe can make worth the infinity.");

    }

}

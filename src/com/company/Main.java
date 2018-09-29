package com.company;
import java.util.*;


public class Main {
    //STATIC CARD ATTRIBUTE DATA
    private static final List<String> COLORS  = Arrays.asList("RED", "BLACK");
    private static final List<String> RANKS  = Arrays.asList("ACE" ,"KING", "QUEEN", "JACK", "TEN", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO");
    private static final List<String> SUITS  = Arrays.asList("SPADES", "CLUBS", "DIAMONDS", "HEARTS");

    // SESSION SCORE
    private static int SCORE = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // CARD GAME INTRODUCTION
        do {
            SCORE = 0;
            header();
            stepOne(sc);
            System.out.println("Play again? (Y|N)");
        }while(!sc.nextLine().toUpperCase().equals("N"));
    }

    // DEVIATION HEADER
    public static void header(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                 Deviation - The Card Game of Champions");
        System.out.println("----------------------------------------------------------------------");
    }

    // DETERMINE RESULTS
    public static boolean printRes(boolean res){
        if(res) {
            System.out.println("CORRECT!");
        } else {
            System.out.println("INCORRECT! Back to Step One!");
        }
        return res;
    }

    // STEP 1 - COLOR GUESS
    public static void stepOne(Scanner sc){
        System.out.println("\n**STEP ONE**");
        System.out.println("Nous allons! Guess the next card's color (RED or BLACK): ");
        String input = sc.nextLine().toUpperCase();
        RandomCard randCard = new RandomCard();
        System.out.println("The color you picked was: " + input);
        System.out.println("The next card generated was: " + randCard.printCard());
        if(printRes(randCard.getColor().equals(input))) stepTwo(sc, randCard);
        else{
            SCORE += 3;
            stepOne(sc);
        }    }

    // STEP 2 - RANK GUESS
    public static void stepTwo(Scanner sc, RandomCard randPrev){
        System.out.println("\n**STEP TWO**");
        System.out.println("Almost there! Is the next card's rank higher than the last? (Y or N):");
        String input = sc.nextLine().toUpperCase();
        RandomCard randCard = new RandomCard();
        System.out.println("The rank you picked was: " + input);
        System.out.println("The previous card generated was: " + randCard.printCard());
        System.out.println("The next card generated was: " + randCard.printCard());
        boolean res = (input.equals("Y")) ?
                RANKS.indexOf(randCard.getRank()) <= RANKS.indexOf(randPrev.getRank()):
                RANKS.indexOf(randCard.getRank()) >= RANKS.indexOf(randPrev.getRank());
        if(res) stepThree(sc);
        else{
            SCORE += 2;
            stepOne(sc);
        }
    }

    // STEP 3 - RANK GUESS
    public static void stepThree(Scanner sc){
        System.out.println("\n**STEP THREE**");
        System.out.println("Last one! Guess the next card's suit (SPADES, HEARTS, DIAMONDS, or CLUBS):");
        String input = sc.nextLine().toUpperCase();
        RandomCard randCard = new RandomCard();
        System.out.println("The suit you picked was: " + input);
        System.out.println("The suit card generated was: " + randCard.getSuit());
        if(printRes(randCard.getSuit().equals(input))){
            System.out.println("\nCongratulations! You've beaten Deviation!");
            System.out.println("Your score was: " + SCORE);
        } else{
            SCORE++;
            stepOne(sc);
        }
    }

    public static class RandomCard{

        // RANDOM CARD ATTRIBUTES
        private String color;
        private String rank;
        private String suit;

        // ASSIGN RANDOM ATTRIBUTES TO GENERATED CARD
        public RandomCard(){
            color = generateRandomColor();
            rank = generateRandomRank();
            suit = generateRandomSuit();
        }

        // ACCESSOR FUNCTIONS
        public String getColor(){
            return color;
        }

        public String getRank(){
            return rank;
        }

        public String getSuit(){
            return suit;
        }

        // RANDOM COLOR GENERATOR
        public String generateRandomColor(){
            return COLORS.get((int) Math.floor((Math.random() * COLORS.size())));
        }

        // RANDOM RANK GENERATOR
        public String generateRandomRank(){
            return RANKS.get((int) Math.floor((Math.random() * RANKS.size())));
        }

        // RANDOM SUIT GENERATOR
        public String generateRandomSuit(){
            return SUITS.get((int)Math.floor((Math.random() * SUITS.size())));
        }

        // PRINT OUT CARD
        public String printCard(){
            return (getColor() + " " + getRank() + " of " + getSuit());
        }
    }

}


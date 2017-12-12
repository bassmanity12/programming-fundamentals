package com.company;

import java.util.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int gameplay = 1;
        List<String> cardRanks = Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");
        //String [] cardSuits = {"♠","♥","♦","♣"};
        List<String> newDeck = initializeDeck(cardRanks);
        // printcards(newDeck);
        List<Player> Playerlist = new ArrayList<>(); //Making a list of players.


        while (gameplay == 1) {
            System.out.println("\n\n/////////////////Chali Farash////////////////////");
            System.out.println("      A game made by Basanta Lamichhane\n\n\n ");
            System.out.println("Press 1 to start the game, 2 to exit");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    Playerlist.clear();
                    Collections.shuffle(newDeck);
                    // printcards(newDeck);
                    System.out.println("How many players do you want in the game? ");
                    int number_of_players = input.nextInt();
                    if (number_of_players > 17) {
                        System.out.println("Sorry! This game can only be played with maximum of 17 players");
                        continue;
                    }
                    System.out.println("How much do you want the initial bet to be? ");
                    float initial_bet = input.nextFloat();
                    for (int i = 0; i < number_of_players; i++) {
                        System.out.println("Write the names of the player");
                        String n = input.next();
                        List<String> Hands = new ArrayList<>();
                        // printcards(newDeck);
                        
                        for (int j = 0; j < 3; j++) {
                            String pl = newDeck.get(newDeck.size() - 1); // extracting the last card from the Deck
                            newDeck.remove(newDeck.size() - 1); // Removing the last card from the Deck
                            Hands.add(pl); //Assigning that card to players hands
                        }

                        Playerlist.add(new Player(n, initial_bet, Hands));
                        //  Playerlist.get(i).hands = Playerlist.get(i).sortedHands();

                    }
                    setPrioritis(Playerlist, cardRanks);
                    printPlayers(Playerlist);
                    Player winner = SelectWinner(Playerlist, cardRanks);
                    System.out.println();
                    System.out.println("The Winner is "+ winner.Name);
                    // printcards(newDeck); */
                    break;
                case 2:
                    break;
            }

        }


    }

    // private static List<Player> popPlayer(List<Player> listo) {

       // return listo;

    //}

    private static List<String> initializeDeck(List<String> cardRanks) { //method to initialize a new Deck of Card
        List<String> newDeck = new ArrayList<>();
        int j = 0;
        for (int i = 1; i < 53; i++) {
            newDeck.add(cardRanks.get(j));
            if (i % 4 == 0)
                j++;

        }
        return newDeck;


    }

    private static void printcards(List<String> newDeck) { //method for printing the cards
        for (String b : newDeck)
            System.out.println(b);
    }

    private static void printPlayers(List<Player> Playerlist) { // methods for printing player's name and hands
        for (Player b : Playerlist) {
            System.out.println("The hands of the player " + b.Name+ " is");
            for (String card : b.hands)
                System.out.println(card);
                System.out.println();
        }
    }

    private static void setPrioritis(List<Player> PlayerList, List<String> cardRanks) { // running main algorithm for setting priorities
        for (Player b : PlayerList) {

            if (b.hands.get(0).equals(b.hands.get(1)) && b.hands.get(1).equals(b.hands.get(2))) {
                b.priority_type = 0; //  means highest priority whose range is 0-13 if all cards are the same

            } else if ((b.hands.get(0).equals(b.hands.get(1)) && !b.hands.get(1).equals(b.hands.get(2))) // in case two cards are same
                    || (b.hands.get(1).equals(b.hands.get(2)) && !b.hands.get(2).equals(b.hands.get(0)))
                    || (b.hands.get(0).equals(b.hands.get(2)) && !b.hands.get(2).equals(b.hands.get(1)))) {

                b.priority_type = 2;

            } else {

                b.priority_type = 3;

            }

            b.priority_num[0] = b.getIndex(cardRanks, 0); // getting the priorities
            b.priority_num[1] = b.getIndex(cardRanks, 1);
            b.priority_num[2] = b.getIndex(cardRanks, 2);
            b.sortedHands();

        }


    }

    private static Player SelectWinner(List<Player> list_of_players, List<String> CardRanks) {
        Player winner = list_of_players.get(0);
        for (Player b : list_of_players) {

            if (b.priority_type < winner.priority_type)
                winner = b;
            else if (b.priority_type == winner.priority_type) {
                int bind1 = b.getIndex(CardRanks, 0);
                int bind2 = b.getIndex(CardRanks, 1);
                int bind3 = b.getIndex(CardRanks, 2);

                int wind1 = winner.getIndex(CardRanks, 0);
                int wind2 = winner.getIndex(CardRanks, 1);
                int wind3 = winner.getIndex(CardRanks, 2);

                if (b.priority_type == 2) { //finding the highest card in hand
                    int highest = 0;
                    for (int s : b.priority_num) {
                        if (s > highest)
                            highest = s;
                    }
                    int highest1 = 0;
                    for (int s : winner.priority_num) {
                        if (s > highest)
                            highest1 = s;
                    }
                    if (highest > highest1)
                        winner = b;

                } else {
                    if (bind1 == bind2 + 1 && bind1 == bind3 + 2)
                        winner = b;
                    else {
                        if (bind1 > wind1)
                            winner = b;
                        else if (bind1 == wind1) {
                            if (bind2 > wind2)
                                winner = b;
                            else if (bind2 == wind2) {
                                if (bind3 > wind3)
                                    winner = b;

                            }
                        }
                    }
                }

            }
        }
        return winner;

    }

}
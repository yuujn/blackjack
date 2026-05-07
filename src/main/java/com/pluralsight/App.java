package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the number of players: ");
        int playerCount = Integer.parseUnsignedInt(scan.nextLine());

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            System.out.printf("Enter Player %d's name: ", i + 1);
            String name = scan.nextLine();
            players.add(new Player(name, new Hand()));
        }

        Deck deck = new Deck();

        // Deal.
        for (Player player : players) {
            Hand hand = player.getHand();
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        // TODO:
        // 1. Display hand
        // 2. Keep track of who has the highest score below or equal to 21
        for (Player player : players) {

        }
    }
}

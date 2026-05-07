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
        deck.shuffle();

        // Deal.
        for (Player player : players) {
            Hand hand = player.getHand();
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        Player highestPlayer = null;
        for (Player player : players) {
            System.out.printf("%s has these cards: %s%n", player.getName(), player.getHand());
            if (highestPlayer == null) {
                highestPlayer = player;
                continue;
            }

            // TODO: deal with ties
            if (player.getHand().getValue() > highestPlayer.getHand().getValue()
                    && player.getHand().getValue() <= 21) {
                highestPlayer = player;
            }
        }

        if (highestPlayer == null) {
            System.out.println("Nobody wins! Sorry.");
        } else {
            System.out.printf(
                    "%s is the winner with %d points!%n",
                    highestPlayer.getName(),
                    highestPlayer.getHand().getValue()
            );
        }
    }
}

package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            card.flip(); // turn the card over to see the value
            value += card.getPointValue();
            card.flip(); // hide the card again
        }
        // Steps:
        // 1. Count the number of aces in the hand.
        // 2. Check how many aces we need to turn into 1s to avoid busting.
        int aceCount = 0;
        for (Card card : cards) {
            card.flip();
            if (card.getValue().equals("A")) {
                aceCount += 1;
            }
            card.flip();
        }
        int minValue = value - (aceCount * 10);
        int allowedElevens = 0;
        for (int i = 1; i <= aceCount; i++) {
            if (minValue + (i * 10) <= 21) {
                allowedElevens = i;
            } else {
                break;
            }
        }
        value = minValue + (allowedElevens * 10);
        return value;
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        boolean isFirst = true;
        for (Card card : cards) {
            if (isFirst) {
                isFirst = false;
            } else {
                handString.append(" ");
            }
            boolean shouldFlipBack = false;
            if (!card.isFaceUp()) {
                card.flip();
                shouldFlipBack = true;
            }
            handString.append(card.getValue());
            if (shouldFlipBack) {
                card.flip();
            }
        }
        return handString.toString();
    }
}

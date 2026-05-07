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

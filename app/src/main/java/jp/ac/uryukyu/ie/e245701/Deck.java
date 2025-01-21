package jp.ac.uryukyu.ie.e245701;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;

    public Deck() {
        deck = new ArrayList<>();
        mkDeck();
        hand = new ArrayList<>();
        dealCards();
    }

    public void mkDeck() {
        String[] suits = {"ハート", "ダイアモンド", "クラブ", "スペード"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String number : numbers) {
                deck.add(new Card(suit, number));
            }
        }
        Collections.shuffle(deck);
        //System.out.println(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void dealCards() {
        for (int i=0; i<=4; i++) {
            Card item = deck.get(i);
            hand.add(item);
        }
        System.out.println(hand);
    }
}


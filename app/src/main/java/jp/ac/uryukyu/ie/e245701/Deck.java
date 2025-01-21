package jp.ac.uryukyu.ie.e245701;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;

    public Deck() {
        deck = new ArrayList<>();
        mkDeck();
        hand = new ArrayList<>();
        dealCards();
        gameMaster();
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

    public void gameMaster() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>number = new ArrayList<>();
        
        System.out.println("交換する枚数を入力してください");
        int choice = scanner.nextInt();
        for (int i=0; i<choice; i++) {
            System.out.println("交換するカードを選んでください 左から[1,2,3,4,5]");
            int j = scanner.nextInt();
            int choose = j - 1;
            number.add(choose);
        }
        System.out.println(number);
    }

}


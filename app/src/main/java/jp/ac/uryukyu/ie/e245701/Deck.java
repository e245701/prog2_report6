package jp.ac.uryukyu.ie.e245701;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> firstHand;
    private ArrayList<Card> secondHand;

    public Deck() {
        deck = new ArrayList<>();
        mkDeck();
        firstHand = new ArrayList<>();
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
        System.out.println(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void dealCards() {
        for (int i=0; i<=4; i++) {
            Card item = deck.get(i);
            firstHand.add(item);
        }
        System.out.println(firstHand);
    }

    public void gameMaster() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>numbers = new ArrayList<>();
        secondHand = new ArrayList<>();
        
        System.out.println("残したい枚数を入力してください");
        int choice = scanner.nextInt();
        for (int i=0; i<choice; i++) {
            System.out.println("残すカードを選んでください 左から[1,2,3,4,5]");
            int j = scanner.nextInt();
            int choose = j - 1;
            numbers.add(choose);
        }

        for (int number : numbers) {
            Card item = deck.get(number);
            secondHand.add(item);
        }

        for (int i=5; i<=9-choice; i++) {
            Card item = deck.get(i);
            secondHand.add(item);
        }
        System.out.println(secondHand);
    }

}


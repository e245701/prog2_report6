package jp.ac.uryukyu.ie.e245701;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * ポーカーのメイン部分となるクラス
 * 最初に５２枚のランダムな順番にカードが保存されたdeckを生成
 * 次にdeckの0番めから５枚をfirstHandに保存する
 * その後保持したいカードを選択し、捨てた枚数分デッキの5番めから取得して、secondHandに保存する
 */
public class Deck {
    /**
     * デッキ。52枚のカードを保存
     */
    private ArrayList<Card> deck;
    /**
     * 最初にプレイヤーが保持する5枚を保存
     */
    private ArrayList<Card> firstHand;
    /**
     * カードを交換後の5枚を保存
     */
    private ArrayList<Card> secondHand;
    /**
     * デッキ作成からデッキシャッフル、手札生成まで
     */
    public Deck() {
        deck = new ArrayList<>();
        mkDeck();
        firstHand = new ArrayList<>();
        dealCards();
    }
    /**
     * デッキを生成するメソッド52枚のカード
     */
    public void mkDeck() {
        String[] suits = {"ハート", "ダイヤモンド", "クラブ", "スペード"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String number : numbers) {
                deck.add(new Card(suit, number));
            }
        }
        Collections.shuffle(deck);
        //System.out.println(deck);
    }
    /**
     * getterメソッドdeckを取得する
     * @return
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    /**
     * カードを配るメソッドデッキの0番めから5枚を手札に配る
     */
    public void dealCards() {
        for (int i=0; i<=4; i++) {
            Card item = deck.get(i);
            firstHand.add(item);
        }
        System.out.println("あなたの手札");
        System.out.println(firstHand);
    }
    /**
     * ゲームの進行を司るメソッド、残したい枚数をscannerで取得
     * 同じ数字を入力するとカードが増殖するので注意
     */
    public void gameMaster() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>numbers = new ArrayList<>();
        secondHand = new ArrayList<>();
        
        System.out.println("残したい枚数を入力してください");
        int choice = scanner.nextInt();
        if (choice < 5) {
            for (int i=0; i<choice; i++) {
                System.out.println("残すカードを選んでください 左から[1,2,3,4,5]");
                int j = scanner.nextInt();
                int choose = j - 1;
                numbers.add(choose);
            }
        }
        else {
            for (int i=0; i<=4; i++) {
                numbers.add(i);
            }
        }

        for (int number : numbers) {
            Card item = deck.get(number);
            secondHand.add(item);
        }

        for (int i=5; i<=9-choice; i++) {
            Card item = deck.get(i);
            secondHand.add(item);
        }
        System.out.println("あなたの手札");
        System.out.println(secondHand);

        flash();
    }
    /**
     * 役の判定メソッド。フラッシュの判定
     * スートを一つずつ比較し、同じならi+1、i=5でフラッシュ判定
     */
    public void flash() {
        Card firstCard = secondHand.get(0);
        String firstSuit = firstCard.getSuit();
        int i = 0;
        for (Card card : secondHand) {
            String suit = card.getSuit();
            if (firstSuit == suit) {
                i +=1;
            }else {
                break;
            }
            if (i == 5) {
                System.out.println("フラッシュ");
            }
        }
    }

}


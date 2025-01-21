package jp.ac.uryukyu.ie.e245701;
/**
 * トランプのカード部分
 * 
 * スートと1〜13の数字を組み合わせた計52枚を用意
 */
public class Card {
    /**
     * ハート、スペード、クラブ、ダイヤの４種類
     */
    private String suit;  
    /**
     * 2~10とJ、Q、K、Aの計13種類
     */
    private String number;  
    /**
     * コンストラクタ。初期化するだけ
     * @param suit
     * @param number
     */
    public Card(String suit, String number) {
        this.suit = suit;
        this.number = number;
    }
    /**
     * getterメソッド。suitを取得する
     * @return
     */
    public String getSuit() {
        return suit;
    }
    /**
     * getterメソッド。numberを取得する
     * @return
     */
    public String getNumber() {
        return number;
    }
    /**
     * toString関数。printlnで表示されてしまう１６進数の文字列を任意の文字列に変換する。
     */
    @Override
    public String toString() {
        return suit + "の" + number;
    }

}

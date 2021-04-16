package dev.boxz;

import java.util.ArrayList;
import java.util.Arrays;

public class PokerHands {


    private static class Hand{
        private Card[] hand;
        private enum handRank{
            HIGHCARD, PAIR, TWOPAIR, THREEOFAKIND, STRAIGHT, FLUSH,
            FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH
        }
        private String name;
        public Hand(String handString, String name){
            this.name=name;
            String[] cards = handString.split(" ");
            Card[] hand=new Card[cards.length];
            for (int i=0;i< cards.length;i++){
                hand[i]=new Card (cards[i]);
            }
            this.hand=hand;

        }
        public Card[] numPair(){
            ArrayList<Card> res=new ArrayList<Card> ();
            for (int i=0;i< this.hand.length-2;i++){
                if (hand[i].equals (hand[i+1])&&!hand[i].equals (hand[i+2])){
                    res.add (hand[i+1]);
                }
            }
            if (hand[hand.length-2]==hand[hand.length-1]){
                res.add (hand[hand.length-1]);
            }
            return ( Card[] ) res.toArray ();
        }
        public Card isPair(){
            if (numPair ().length==1){
                return numPair ()[0];
            }
            else {
                return null;
            }
        }
        public Card[] isTwoPari(){
            if (numPair ().length==2){
                return numPair ();
            }
            else {
                return null;
            }
        }
        public Card[] numThreeOfaKind(){
            ArrayList<Card> res=new ArrayList<Card> ();

            return ( Card[] ) res.toArray ();
        }
        public Hand (Card[] hand, String name) {
            this.hand = hand;
            this.name = name;
        }

        public Card[] getHand () {
            return hand;
        }

        public void setHand (Card[] hand) {
            this.hand = hand;
        }

        public String getName () {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        @Override
        public boolean equals (Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass () != o.getClass ()) {
                return false;
            }
            Hand hand1 = ( Hand ) o;
            return Arrays.equals (this.hand, hand1.getHand ());
        }
    }

    private static class Card implements Comparable<Card>{
        private char suit;
        private int value;
        public Card(String card){
            this.value=Integer.valueOf (String.valueOf (card.charAt (0)));
            this.suit=card.charAt (1);
        }
        public char getSuit () {
            return suit;
        }

        public void setSuit (char suit) {
            this.suit = suit;
        }

        public int getValue () {
            return value;
        }

        public void setValue (int value) {
            this.value = value;
        }

        Card (char suit, int value) {
            this.suit = suit;
            this.value = value;
        }

        public boolean compareSuit(Card anotherCard){
            return this.suit==anotherCard.getSuit ();
        }

        @Override
        public int compareTo (Card anotherCard) {
            if (this.value> anotherCard.getValue ()){
                return 1;
            }
            else if (this.value==anotherCard.getValue ()){
                return 0;
            }
            return -1;
        }

        @Override
        public boolean equals (Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass () != o.getClass ()) {
                return false;
            }
            Card card = ( Card ) o;
            return this.value == card.getValue ();
        }

    }
}

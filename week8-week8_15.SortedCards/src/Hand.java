/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Hand implements Comparable<Hand> {
    List<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print() {
        Collections.sort(hand);
        for (Card c : this.hand) {
            System.out.println(c);
        }
    }

    @Override
    public int compareTo(Hand o) {
        int hand1 = 0;
        int hand2 = 0;
        
        for (Card c : this.hand) {
            hand1 += c.getValue();
        }
        for (Card c : o.hand) {
            hand2 += c.getValue();
        }
        
        return hand1 - hand2;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand , new SortAgainstSuitAndValue());
    }
    
    
    
}

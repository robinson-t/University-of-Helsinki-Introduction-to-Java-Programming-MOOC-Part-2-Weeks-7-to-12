/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.Comparator;
public class SortAgainstSuitAndValue implements Comparator<Card> {

    @Override
    public int compare(Card card2, Card card1) {
        if (card1.getSuit() != card2.getSuit()) {
            return card1.getSuit() - card2.getSuit();
        } else {
            return card1.getValue() - card2.getValue();
        }
    }
    
}
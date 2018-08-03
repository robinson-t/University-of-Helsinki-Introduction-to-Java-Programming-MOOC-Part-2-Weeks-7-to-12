/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.*;
public class ShoppingBasket {
    private Map<String , Purchase> purchases;

    public ShoppingBasket() {
        this.purchases = new HashMap<String ,Purchase>();
        
        
    }
    
    public void add(String product , int price) {
        if (this.purchases.keySet().contains(product)) {
            for (Purchase p : this.purchases.values()) {
                if (p.getProduct().equals(product)) {
                    p.increaseAmount();
                }
            }
        } else {
            Purchase purchase = new Purchase (product , price , 1);
            this.purchases.put(product, purchase);
        }
        
        
    }
    
    public int price() {
        if (this.purchases.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (Purchase p : this.purchases.values()) {
            total += p.price();
        }
        return total;
        
       
    }
    
    public void print() {
        for (Purchase p : this.purchases.values()) {
            System.out.println(p);
        }
    }
    
    
    
    
}

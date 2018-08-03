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
public class PromissoryNote {
    
    private Map<String, Double> loans;

    public PromissoryNote() {
        this.loans = new HashMap<String, Double>();
    }
    
    
    public void setLoan(String toWhom, double value) {
        String owner = toWhom;
        //owner = owner.trim();
        //owner = owner.toLowerCase();
        
        this.loans.put(owner, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (this.loans.containsKey(whose)) {
            return this.loans.get(whose);
        }
        else {
            return 0;
        }
    }
}

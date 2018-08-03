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
public class Container {
    private int maxWeight;
    private List<Suitcase> suitcases;

    public Container(int max) {
        this.maxWeight = max;
        this.suitcases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        int weight = 0;
        for (Suitcase s : this.suitcases) {
            weight += s.totalWeight();
        }
        if ((weight + suitcase.totalWeight()) <= this.maxWeight) {
            this.suitcases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase s : this.suitcases) {
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        int totalNo = 0;
        int totalWeight = 0;
        for (Suitcase s : this.suitcases) {
            totalNo++;
            totalWeight += s.totalWeight();
        }
        return totalNo + " suitcases (" + totalWeight + " kg)";
    }
    
    
    
    
}

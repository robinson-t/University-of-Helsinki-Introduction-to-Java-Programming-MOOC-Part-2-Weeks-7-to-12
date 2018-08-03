/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.ArrayList;
import java.util.List;
public class Suitcase {
    private List<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        if (maxWeight < 0) {
            this.maxWeight = 0;
        }
        this.things = new ArrayList<Thing>();
        
    }
    
    public void addThing(Thing thing) {
        if ((this.totalWeight() + thing.getWeight()) <= this.maxWeight) {
            this.things.add(thing);
        }
    }
    
    public void printThings() {
        for (Thing t : this.things) {
            System.out.println(t);
        }
    }
    
    public int totalWeight() {
        int weight = 0;
        for (Thing t : this.things) {
            weight += t.getWeight();
        }
        return weight;
    }
    
    public Thing heaviestThing() {
        if (this.things.isEmpty()) {
            return null;
        }
        Thing current = this.things.get(0);
        for (Thing t : this.things) {
            if (t.getWeight() > current.getWeight()) {
                current = t;
            }
        }
        return current;
    }

    @Override
    public String toString() {
        int totalNo = 0;
        int totalWeight = this.totalWeight();
        for (Thing t : this.things) {
            totalNo++;
        }
        
        String output = "";
        if (totalNo == 0) {
            output = "empty (" + totalWeight + " kg)";
        } else if (totalNo == 1) {
            output = totalNo + " thing (" + totalWeight + " kg)";
        } else {
            output = totalNo + " things (" + totalWeight + " kg)";
        }
        
        return output;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author tomro
 */
import java.util.List;
import java.util.ArrayList;
public class MaxWeightBox extends Box {
    private int maxWeight;
    
    private List<Thing> items;
    

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        
        this.items = new ArrayList<Thing>();
    }
    
    

    @Override
    public void add(Thing thing) {
        int currentWeight = 0;
        for (Thing t : this.items) {
            currentWeight += t.getWeight();
        }
        if (thing.getWeight() + currentWeight <= this.maxWeight) {
            this.items.add(thing);
            currentWeight += thing.getWeight();
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : this.items) {
            if (t.equals(thing)) {
                return true;
            }
        }
        return false;
    }
    
}

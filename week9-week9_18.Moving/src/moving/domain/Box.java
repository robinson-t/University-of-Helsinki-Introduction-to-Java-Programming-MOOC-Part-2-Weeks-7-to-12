/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author tomro
 */
import java.util.*;
public class Box implements Thing {
    private int maxCapacity;
    private List<Thing> things;

    public Box(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if ((thing.getVolume() + this.getVolume()) > this.maxCapacity) {
            return false;
        }
        this.things.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int vol = 0;
        for (Thing t : this.things) {
            vol += t.getVolume();
        }
        return vol;
    }
    
    
}

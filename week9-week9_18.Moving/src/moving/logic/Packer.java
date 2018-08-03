/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

/**
 *
 * @author tomro
 */
import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;
import java.util.*;
public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List <Box> boxes = new ArrayList<Box>();
        for (Thing t : things) {
            Box newBox = new Box(this.boxesVolume);
            newBox.addThing(t);
            boxes.add(newBox);
        }
        return boxes;
        
    }
}

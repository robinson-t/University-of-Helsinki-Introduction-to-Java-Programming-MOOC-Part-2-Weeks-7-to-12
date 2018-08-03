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
public class OneThingBox extends Box {
    private Thing thingInBox;

    public OneThingBox() {
    }

    @Override
    public void add(Thing thing) {
        if (this.thingInBox == null) {
            this.thingInBox = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (this.thingInBox == null) {
            return false;
        }
        if (thing.equals(this.thingInBox)) {
            return true;
        }
        return false;
    }
    
    
    
    
    
}

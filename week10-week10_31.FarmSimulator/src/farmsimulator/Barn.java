/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.Collections;
import java.util.Collection;
/**
 *
 * @author tomro
 */
public class Barn {
    private BulkTank barnTank;
    private MilkingRobot barnRobot;
    
    public Barn (BulkTank tank) {
        this.barnTank = tank;
        
    }

    public BulkTank getBulkTank() {
        return barnTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.barnRobot = milkingRobot;
        this.barnRobot.setBulkTank(this.barnTank);
    }
    
    public void takeCareOf (Cow cow) {
        if (this.barnRobot == null) {
            throw new IllegalStateException();
        } else {
        this.barnRobot.milk(cow);
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        if (this.barnRobot == null) {
            throw new IllegalStateException();
        } else {
            for (Cow c : cows) {
                this.barnRobot.milk(c);
            }
        }
    }

    @Override
    public String toString() {
        return Math.ceil(barnTank.getVolume()) + "/" + Math.ceil(barnTank.getCapacity());
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author tomro
 */
public class MilkingRobot {
private BulkTank tank;
    public MilkingRobot() {
        
    }
    
    public BulkTank getBulkTank () {
        if (this.tank == null) {
            return null;
        }
        return this.tank;
    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public void milk(Milkable milkable) {
        if (this.tank == null) {
            throw new IllegalStateException();
        }
        double added = milkable.milk();
        this.tank.addToTank(added);
    }
    
    
}

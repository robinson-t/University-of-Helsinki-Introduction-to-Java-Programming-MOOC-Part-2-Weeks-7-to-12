/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.*;

/**
 *
 * @author tomro
 */
public class Farm implements Alive{
    private String owner;
    private Barn farmBarn;
    private List<Cow> herd;

    public Farm(String owner, Barn farmBarn) {
        this.owner = owner;
        this.farmBarn = farmBarn;
        this.herd = new ArrayList<Cow>();
    }
    
    public void manageCows () {
        this.farmBarn.takeCareOf(herd);
    }
    
    public void addCow(Cow cow) {
        this.herd.add(cow);
    }
    
    public String getOwner () {
        return this.owner;
    }
    
    public void installMilkingRobot (MilkingRobot robot) {
        this.farmBarn.installMilkingRobot(robot);
    }
    
    @Override
    public void liveHour() {
        for (Cow c : this.herd) {
            c.liveHour();
        }
    }

    @Override
    public String toString() {
        String animalsState = "";
        if (this.herd.isEmpty()) {
            animalsState = "No cows.";
        } else {
            animalsState += ("Animals:" + "\n");
            for (Cow c : this.herd) {
                animalsState += ("        " + c.toString() + "\n");
            }
        }
        
        return "Farm owner: " + this.owner + "\n" +
                "Barn bulk tank: " + this.farmBarn.toString() + "\n" +
                animalsState;
    }
    
    
    
}

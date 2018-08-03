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
public class BulkTank {
    private final double capacity;
    private double volume;

    public BulkTank() {
        this.capacity = 2000;
        this.volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }
    
    public double getCapacity() {
        return this.capacity;
        
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    
    public void addToTank (double amount) {
        if ((volume + amount) > this.capacity) {
            this.volume = this.capacity;
            return;
        } else if (amount < 0) {
            return;
        }
        
        this.volume += amount;
    }
    
    public double getFromTank(double amount) {
        if (amount > this.volume) {
            double toReturn = this.volume;
            this.volume = 0;
            return toReturn;
        }
        this.volume -= amount;
        return this.volume;
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(this.capacity);
    }
    
    
    
    
}

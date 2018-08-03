/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author tomro
 */
import java.util.*;
public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor (Sensor additional) {
        this.sensors.add(additional);
        if (!additional.isOn()) {
        }
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
    
    
    
    
    
    
    @Override
    public boolean isOn() {
        for (Sensor s : this.sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }
    

    @Override
    public void on() {
        for (Sensor s : this.sensors) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : this.sensors) {
            s.off();
        }
    }

    @Override
    public int measure() {
        if (this.sensors.isEmpty()) {
            throw new IllegalStateException();
        } else if (!this.isOn()) {
            throw new IllegalStateException();
        }
        
        int mean = 0;
        int num = 0;
        for (Sensor s : this.sensors) {
            int reading = s.measure();
            mean += reading;
            
            num++;
        }
        mean /= num;
        this.readings.add(mean);
        return mean;
        
    }
    
}

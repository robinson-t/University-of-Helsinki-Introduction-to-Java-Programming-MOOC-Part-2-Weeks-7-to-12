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
import java.util.Random;
public class Thermometer implements Sensor {
    private boolean isOn;

    public Thermometer() {
        this.isOn = false;
    }
    
    

    @Override
    public boolean isOn() {
return this.isOn;    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        Random random = new Random();
        if (!this.isOn) {
            throw new IllegalStateException();
        }
        
        else {
            int value = random.nextInt(60) - 30;
            
            return value;
        }
    }
    
    
}

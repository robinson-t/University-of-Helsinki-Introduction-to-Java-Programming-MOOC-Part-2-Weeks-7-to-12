/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author tomro
 */
public class Cow implements Milkable, Alive{
    private Random random;
    private int udderCapacity;
    private double volume;
    private String name;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    
    public Cow() {
        this.random = new Random();
        calculateUdder();
        
        this.volume = 0;
        
        int index = this.random.nextInt(30);
        this.name = NAMES[index];
        
        
    }
    
    public Cow(String name) {
        this.random = new Random();
        this.name = name;
        calculateUdder();
        this.volume = 0;
        
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.udderCapacity;
    }
    
    public double getAmount() {
        return this.volume;
    }

    @Override
    public String toString() {
        return this.name + " "  + Math.ceil(volume) + "/" + (double)this.udderCapacity;//To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void calculateUdder() {
        this.udderCapacity = random.nextInt(26) + 15;
    }
    
    
    

    @Override
    public double milk() {
        double toTake = this.volume;
        this.volume = 0;
        return toTake;
    }

    @Override
    public void liveHour() {
        double gain = random.nextInt(13) + 7;
        gain /= 10;
        if ((this.volume + gain) > this.udderCapacity) {
            this.volume = this.udderCapacity;
        } else {
            this.volume += gain;
        }
    }
    
    
    
}

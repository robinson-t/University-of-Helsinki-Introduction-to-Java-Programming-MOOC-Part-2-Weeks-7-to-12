/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author tomro
 */
public class PersonalCalculator implements Calculator {
    private int clicks;

    public PersonalCalculator() {
        this.clicks = 0;
    }

    @Override
    public int giveValue() {
        return this.clicks;
    }

    @Override
    public void increase() {
        this.clicks++;
    }
    
    
    
    
    
}

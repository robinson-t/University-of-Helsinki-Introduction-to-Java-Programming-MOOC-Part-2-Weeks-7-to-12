/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
public class Flight {
    private Airplane plane;
    private String departure;
    private String arrival;

    public Flight(Airplane plane, String departure, String arrival) {
        this.plane = plane;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airplane getPlane() {
        return plane;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
    

    @Override
    public String toString() {
        return this.plane + " (" + this.departure + "-" + this.arrival + ")";
    }
    
    
    
            
}

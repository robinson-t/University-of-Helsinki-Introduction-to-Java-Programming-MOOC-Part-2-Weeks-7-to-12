/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.*;
public class RingingCentre {
    private Map<Bird, List<String>> sightings;

    public RingingCentre() {
        this.sightings = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird , String place) {
        int isIn = 0;
        for (Bird b : this.sightings.keySet()) {
            if (b.equals(bird)) {
                this.sightings.get(b).add(place);
                isIn = 1;
            }
        }
        if (isIn == 0) {
            this.sightings.put(bird, new ArrayList<String>());
            for (Bird b : this.sightings.keySet()) {
                if (b.equals(bird)) {
                    this.sightings.get(b).add(place);
                }
            }
        }
    }
    
    public void observations(Bird bird) {
        if (sightings.get(bird) == null) {
            System.out.println(bird.toString() + " observations: " + 0);
            //System.out.println(birds.get(bird));
        } else {
            System.out.println(bird.toString() + " observations: " + sightings.get(bird).size());
            System.out.println(sightings.get(bird));
        }
    }
    
    
    
}

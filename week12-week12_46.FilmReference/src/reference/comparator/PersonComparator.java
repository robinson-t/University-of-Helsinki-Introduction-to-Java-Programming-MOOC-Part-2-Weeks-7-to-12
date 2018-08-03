/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author tomro
 */
public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> peopleIdentities;
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
        
    }

    @Override
    public int compare(Person o1, Person o2) {
        for (Person p : this.peopleIdentities.keySet()) {
            if (p.equals(o1)) {
                for (Person k : this.peopleIdentities.keySet()) {
                    if (k.equals(o2)) {
                        return this.peopleIdentities.get(k) - this.peopleIdentities.get(p);
                    }
                }
            }
        }
        return 0;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tomro
 */
public class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        this.employees.add(person);
    }
    
    public void add(List<Person> persons) {
        for (Person p : persons) {
            this.employees.add(p);
        }
    }
    
    public void print() {
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        
    }
    
    public void print (Education education) {
        Iterator<Person> iter = this.employees.iterator();
        
        while (iter.hasNext()) {
            Person p = iter.next();
            if (p.getEducation().equals(education)) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iter = this.employees.iterator();
        
        while (iter.hasNext()) {
            if (iter.next().getEducation().equals(education)) {
                iter.remove();
            }
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author tomro
 */
public class Film {
    private String name;

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        Film compare = (Film) obj;
        if (compare.getName().equals(this.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
    
}

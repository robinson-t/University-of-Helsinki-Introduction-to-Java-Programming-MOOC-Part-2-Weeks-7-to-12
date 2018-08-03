/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomro
 */
public class AtLeastOne implements Criterion{
    private List<Criterion> criterions;

    public AtLeastOne(Criterion... criterions) {
        this.criterions = new ArrayList<Criterion>();
        for (Criterion c : criterions) {
            this.criterions.add(c);
        }
    }
    
    

    @Override
    public boolean complies(String line) {
        for (Criterion c : this.criterions) {
            if (c.complies(line)) {
                return true;
            }
        }
        return false;
    }
    
}

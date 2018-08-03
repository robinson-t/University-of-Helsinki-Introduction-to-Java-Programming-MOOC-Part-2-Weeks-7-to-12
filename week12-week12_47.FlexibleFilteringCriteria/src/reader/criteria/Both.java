/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author tomro
 */
public class Both implements Criterion{
    private Criterion critOne;
    private Criterion critTwo;

    public Both(Criterion critOne, Criterion critTwo) {
        this.critOne = critOne;
        this.critTwo = critTwo;
    }
    
    

    @Override
    public boolean complies(String line) {
        if (critOne.complies(line) && critTwo.complies(line)) {
            return true;
        }
        return false;
    }
    
}

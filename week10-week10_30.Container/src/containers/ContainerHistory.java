/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author tomro
 */
public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        this.history.add(situation);
    }
    
    public void reset() {
        this.history.clear();
    }
    
    public double maxValue() {
        return Collections.max(history);
    }
    
    public double minValue() {
        return Collections.min(history);
    }
    
    public double average() {
        double avg = 0;
        int no = 0;
        for (double d : this.history) {
            avg += d;
            no++;
        }
        return avg/no;
        
    }
    
    public double greatestFluctuation(){
        List<Double> fluctuations = new ArrayList<Double>();
        double greatestFluctuation = 0;
        if(history.isEmpty() || history.size() == 1){
            return greatestFluctuation;
        }else{
            for(int i = history.size() - 1; i >= 1; i--){
                double fluctuation = Math.abs(history.get(i) - history.get(i-1));
                fluctuations.add(fluctuation);
            }
        }
        for(double f : fluctuations){
            if(greatestFluctuation < f){
                greatestFluctuation = f;
            }
        }
        return greatestFluctuation;
    }
    
    public double variance() {
        double mean = average();
        double sum = 0;

        for (double state1 : history) {
            sum += Math.pow((state1 - mean), 2);
        }
        return sum / (history.size() - 1);
    }
    
    @Override
    public String toString () {
        return this.history.toString();
    } 
    
    
    
}

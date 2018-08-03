/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Judge {
    private List<Integer> points;
    private Random random;

    public Judge() {
        points = new ArrayList<Integer>();
        random = new Random();
        judgeJump();
    }
    
    private void judgeJump() {
        for (int i = 0 ; i < 5 ; i++) {
            this.points.add((random.nextInt(10) + 10));
        }
        
    }
    
    public int getJudge() {
        //used for points calculation
        int total = 0;
        Collections.sort(points);
        total += this.points.get(1);
        total += this.points.get(2);
        total += this.points.get(3);
        return total;
    }

    
    public String getResults() {
        return "    judge votes: [" + this.points.get(0) + ", " + this.points.get(1) + ", " +this.points.get(2) + ", " +this.points.get(3) + ", " +this.points.get(4) + "]";
    }
    
    
    
    
    
}

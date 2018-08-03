/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Participant implements Comparable<Participant> {
    private String name;
    private int points;
    private Random random;
    private int length;
    private int totalPoints;
    private String judgeResults;
    private List<Integer> lengths;

    public Participant(String name) {
        this.name = name;
        this.points = 0;
        this.totalPoints = 0;
        this.random = new Random();
        this.length = 0;
        this.judgeResults = "";
        this.lengths = new ArrayList<Integer>();
    }
    
    public void setPoints( int no ) {
        this.points = no + this.length;
        this.totalPoints += points;
        
        
    }
    
    
    public int getPoints() {
        return this.points;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
    
    
    public void jump() {
        this.length = random.nextInt(60) + 60;
        this.lengths.add(length);
    }
    
    public int getLength() {
        return this.length;
    }
    
    public String getName() {
        return name;
    }
    
    public void setJudgeResults (String res) {
        this.judgeResults = res;
    }
    
    public String getJudgeResults () {
        return this.judgeResults;
    }
    
    public String getJumpLengths() {
        String values = "";
        Collections.sort(this.lengths);
        Collections.reverse(lengths);
        int place = 0;
        int upper = this.lengths.size() - 1;
        for (int i : this.lengths) {
            if (place != upper) {
                values += i + " m, ";
                place++;
            } else {
                values += i + " m";
            }
        }
        return values;
    }

    @Override
    public int compareTo(Participant o) {
        return this.totalPoints - o.getTotalPoints();
    }
    
    

    @Override
    public String toString() {
        return this.name + " (" + this.totalPoints + " points)";
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class LineUp {
    private List<Participant> jumpers;

    public LineUp() {
        jumpers = new ArrayList<Participant>();
    }
    
    public void add(Participant p) {
        this.jumpers.add(p);
    }
    
    public void print() {
        System.out.println("Jumping order:");
        int number = 1;
        Collections.sort(jumpers);
        for (Participant p : this.jumpers) {
            System.out.println("  " + number + ". " + p);
            number++;
            
        }
    }
    
    public void printResults() {
        for (Participant p : this.jumpers) {
            Judge judge = new Judge();
            p.jump();
            p.setPoints(judge.getJudge());
            p.setJudgeResults(judge.getResults());
            
        }
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        for (Participant p : this.jumpers) {
            System.out.println("  " + p.getName());
            System.out.println("    length: " + p.getLength() );
            System.out.println(p.getJudgeResults());
        }
        System.out.println("");
    }
    
    public void finalResults() {
        int position = 1;
        for (Participant p : this.jumpers) {
            System.out.println(position + "           " + p);
            System.out.println("            jump lengths: " + p.getJumpLengths());
            position++;
        }
    }
    
    
}

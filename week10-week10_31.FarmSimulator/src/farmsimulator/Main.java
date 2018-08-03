package farmsimulator;
import farmsimulator.*;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        // Test your program here
        

Farm farm = new Farm("Esko", new Barn(new BulkTank()));
MilkingRobot robot = new MilkingRobot();
farm.installMilkingRobot(robot);

farm.addCow(new Cow());
farm.addCow(new Cow());
farm.addCow(new Cow());


farm.liveHour();
farm.liveHour();

farm.manageCows();

System.out.println(farm);
        
        

    }
}
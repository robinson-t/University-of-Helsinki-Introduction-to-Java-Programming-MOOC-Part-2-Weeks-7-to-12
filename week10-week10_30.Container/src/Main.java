import containers.*;
public class Main {

    public static void main(String[] args) {
        ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
juice.takeFromTheContainer(11.3);
juice.addToTheContainer(1.0);
//System.out.println(juice.history()); // [1000.0, 988.7, 989.7]

juice.printAnalysis(); 
    }

}

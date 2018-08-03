
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
        
        
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
        Thing brick = new Thing("brick" , 4);
        for (int i = 0 ; i < 100 ; i++) {
            Suitcase s = new Suitcase(100);
            s.addThing(brick);
            container.addSuitcase(s);
        }
    }

}

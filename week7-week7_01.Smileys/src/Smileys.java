
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
        
    }
    private static void printWithSmileys(String characterString) {
        String withSmileys = characterString;
        if ((withSmileys.length() % 2) == 1) {
            withSmileys += " ";
        }
        int length = (withSmileys.length() / 2) + 3;
        printSmiley(length);
        System.out.println(":)" + " " + withSmileys + " " + ":)");
        printSmiley(length);
        
        
    }
    
    private static void printSmiley(int no) {
        for (int i = no; i>0; i--) {
            System.out.print(":)");
        } 
        System.out.println("");
    }

}

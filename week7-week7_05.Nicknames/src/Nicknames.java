
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String , String> nicknames = new HashMap<String, String>();
        
        nicknames.put("matti" , "mage");
        nicknames.put("mikael" , "mixu");
        nicknames.put("arto" , "arppa");
        
        System.out.println(nicknames.get("mikael"));
        
    }

}

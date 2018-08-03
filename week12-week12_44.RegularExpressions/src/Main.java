
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write test code here
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("string");
            String string = reader.nextLine();
            if (allVowels(string)) {
                System.out.println("vowels true");
            }
            if (isAWeekDay(string)) {
                System.out.println("week true");
            }
            if (clockTime(string)) {
                System.out.println("clock true");
            }
        }
    }
    
    public static boolean isAWeekDay(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            return true;
        }
        return false;
    }
    
    public static boolean allVowels(String string) {
        return string.matches("[aeiouöä]*");
    }
    
    public static boolean clockTime(String string) {
        //return string.matches("[0-23]:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}");
        if (string.charAt(0) == '0') {
            return string.matches("0[0-9]{1}:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}");
        } else if (string.charAt(0) == '1') {
            return string.matches("1[0-9]{1}:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}");
        } else if (string.charAt(0) == '2') {
            return string.matches("2[0-3]{1}:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}");
        }
        else {
            return false;
        }
        
    }
}

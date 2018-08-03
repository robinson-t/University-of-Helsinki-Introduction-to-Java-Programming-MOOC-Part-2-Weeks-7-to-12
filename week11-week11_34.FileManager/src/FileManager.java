
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        List<String> toReturn = new ArrayList<String>();
        File toBeRead = new File(file);
        Scanner reader = new Scanner(toBeRead);
        while (reader.hasNextLine()) {
            toReturn.add(reader.nextLine());
            
        }
        reader.close();
        return toReturn;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (String s : texts) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}

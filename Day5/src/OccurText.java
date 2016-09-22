import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

/**
 * Created by tranh on 12-Sep-16.
 */
public class OccurText {
    public static void main(String[] args) {

        String textInput = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"));) {
            while (bufferedReader.ready()) {
                textInput += bufferedReader.readLine();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        char[] charOfText = textInput.toCharArray();
        Map<Character, Integer> hashmap = new HashMap<>();
        for (char c : charOfText) {
            if (!hashmap.containsKey(c)) {
                hashmap.put(c, 1);
            } else {
                hashmap.put(c, hashmap.get(c) + 1);
            }
        }
        System.out.println(hashmap);
    }
}

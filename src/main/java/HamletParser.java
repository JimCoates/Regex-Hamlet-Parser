import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public String removeHoratio(String text) {
        Pattern pattern = Pattern.compile("\\bHoratio\\b", Pattern.CASE_INSENSITIVE);
        text = pattern.matcher(text).replaceAll("Leon");
        return text;
    }

    public String removeHamlet(String text) {
        Pattern pattern = Pattern.compile("\\bHamlet\\b", Pattern.CASE_INSENSITIVE);
        text = pattern.matcher(text).replaceAll("Tariq");
        return text;
    }

    public String removeHoratioAndHamlet(String text){
        String newText = removeHamlet(text);
        newText = removeHoratio(newText);
        return newText;
    }
}

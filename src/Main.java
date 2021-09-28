import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] words;
    static HashMap<String, Integer> mapOfWords = new HashMap<>();

    public static void main(String[] args) {
        readWords();
        System.out.println("Before sort: ");
        print(words);
        Arrays.sort(words);
        System.out.println();
        System.out.println("After sort: ");
        print(words);
        addWordsToMap();
        printStat();

    }

    static void readWords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("text.txt")));
            words = reader.readLine().split(" ");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printStat() {
        int count = 0;
        String word = "";
        for (Map.Entry entry : mapOfWords.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if ((int) entry.getValue() > count) {
                word = entry.getKey().toString();
                count = (int) entry.getValue();
            }
        }
        System.out.println("Most frequently word - " + word + " - seems " + count + " times");
    }

    static void addWordsToMap() {
        for (String s : words) {
            if (mapOfWords.containsKey(s)) {
                mapOfWords.put(s, mapOfWords.get(s) + 1);
            } else mapOfWords.put(s, 1);
        }
    }

    static void print(String[] array) {
        for (String s : array) {
            System.out.print(s + " ");
        }
    }
}

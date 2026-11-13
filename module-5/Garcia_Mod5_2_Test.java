
/*
 * Name: Perla Garcia Cavazos
 * Date: November 12, 2026
 * Course: CSD 420 - Advanced Java Programming
 * Assignment: Module 5.2 Programming Assignment
 *
 * This test program checks that a TreeSet removes
 * duplicate words and sorts the remaining words
 * in ascending and descending order.
 */

import java.util.Arrays;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Garcia_Mod5_2_Test {

    public static void main(String[] args) {

        // Sample words, including duplicates
        String[] sampleWords = {
            "apple", "banana", "orange",
            "apple", "grape", "banana"
        };

        // Remove duplicates and sort the words
        TreeSet<String> words =
            new TreeSet<>(Arrays.asList(sampleWords));

        // Expected results
        String[] expectedAscending = {
            "apple", "banana", "grape", "orange"
        };

        String[] expectedDescending = {
            "orange", "grape", "banana", "apple"
        };

        // Check ascending order
        boolean ascendingTest = Arrays.equals(
            words.toArray(new String[0]),
            expectedAscending
        );

        // Check descending order
        boolean descendingTest = Arrays.equals(
            words.descendingSet().toArray(new String[0]),
            expectedDescending
        );

        // Check that duplicates were removed
        boolean duplicateTest = words.size() == 4;

        System.out.println("Ascending Order Test: "
            + (ascendingTest ? "PASS" : "FAIL"));

        System.out.println("Descending Order Test: "
            + (descendingTest ? "PASS" : "FAIL"));

        System.out.println("Duplicate Removal Test: "
            + (duplicateTest ? "PASS" : "FAIL"));

        // Test reading words from the actual text file.
        try {
            File file = new File("collection_of_words.txt");
            Scanner scanner = new Scanner(file);

            TreeSet<String> fileWords = new TreeSet<>();
            int totalWords = 0;

            while (scanner.hasNext()) {
                String word = scanner.next();
                fileWords.add(word);
                totalWords++;
            }

            scanner.close();

            boolean fileTest =
                totalWords == 14 && fileWords.size() == 10;

            System.out.println("File Reading Test: "
                + (fileTest ? "PASS" : "FAIL"));

        } catch (FileNotFoundException e) {
            System.out.println("File Reading Test: FAIL");
        }
    }
}
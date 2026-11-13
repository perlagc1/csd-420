
/*
 * Name: Perla Garcia Cavazos
 * Date: November 12, 2026
 * Course: CSD 420 - Advanced Java Programming
 * Assignment: Module 5.2 Programming Assignment
 *
 * This program reads words from a text file, removes
 * duplicate words, and displays the remaining words
 * in ascending and descending alphabetical order.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Garcia_Mod5_2 {

    public static void main(String[] args) {

        // TreeSet removes duplicates and sorts words.
        TreeSet<String> words = new TreeSet<>();

        try {
            // Open the text file containing the words.
            File file = new File("collection_of_words.txt");
            Scanner scanner = new Scanner(file);

            // Read each word and add it to the TreeSet.
            while (scanner.hasNext()) {
                String word = scanner.next();
                words.add(word);
            }

            scanner.close();

            // Display words in ascending order.
            System.out.println("Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            // Display words in descending order.
            System.out.println("\nDescending Order:");
            for (String word : words.descendingSet()) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            // Display a message if the file is missing.
            System.out.println("File not found: "
                    + e.getMessage());
        }
    }
}
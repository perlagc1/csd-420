
/*
 * Name: Perla Garcia Cavazos
 * Date: October 27, 2026
 * Course: CSD 402
 * Assignment: Module 2.2 Programming Assignment
 *
 * Purpose: Read and display the contents of
 * Garcia datafile.dat.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Garcia_Mod2_2 {

    public static void main(String[] args) {

        // Open the data file and read its contents.
        try (Scanner scanner = new Scanner(
                new File("Garcia datafile.dat"))) {

            System.out.println("Contents of data file:");
            System.out.println("----------------------");

            // Display each line of the file.
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println(
                "Error reading file: " + e.getMessage()
            );
        }
    }
}

/*
 * Name: Perla Garcia Cavazos
 * Date: October 27, 2026
 * Course: CSD 402
 * Assignment: Module 2.2 Programming Assignment
 *
 * Purpose: Generate an array of five random integers
 * and an array of five random doubles. Write the
 * values to a data file, creating it if necessary
 * and appending data if the file already exists.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Garcia_Mod2_1 {

    public static void main(String[] args) {

        Random random = new Random();

        int[] integers = new int[5];
        double[] doubles = new double[5];

        // Generate five random integers and doubles.
        for (int i = 0; i < 5; i++) {
            integers[i] = random.nextInt(100);
            doubles[i] = random.nextDouble() * 100;
        }

        // Append data, or create the file if missing.
        try (PrintWriter writer = new PrintWriter(
                new FileWriter("Garcia datafile.dat", true))) {

            writer.println("Random Integers:");

            for (int number : integers) {
                writer.println(number);
            }

            writer.println("Random Doubles:");

            for (double number : doubles) {
                writer.println(number);
            }

            writer.println("--------------------");

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println(
                "Error writing file: " + e.getMessage()
            );
        }
    }
}
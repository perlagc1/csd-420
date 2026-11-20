
/*
 * Name: Perla Garcia Cavazos
 * Date: November 20, 2026
 * Assignment: Module 6 Programming Assignment
 * Course: CSD 420
 *
 * Description:
 * This program demonstrates two generic bubble sort methods.
 * One method uses Comparable, and the other uses Comparator.
 */

import java.util.Comparator;

public class BubbleSort {

    
    // Generic bubble sort using Comparable
    public static <T extends Comparable<? super T>>
            void bubbleSort(T[] array) {

        // Repeat the sorting process for each element
        for (int i = 0; i < array.length - 1; i++) {

            // Compare neighboring elements
            for (int j = 0; j < array.length - 1 - i; j++) {

                // Swap elements if they are in the wrong order
                if (array[j].compareTo(array[j + 1]) > 0) {

                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Generic bubble sort using Comparator
    public static <T> void bubbleSort(
            T[] array, Comparator<? super T> comparator) {

        // Repeat the sorting process for each element
        for (int i = 0; i < array.length - 1; i++) {

            // Compare neighboring elements
            for (int j = 0; j < array.length - 1 - i; j++) {

                // Use Comparator to compare two elements
                if (comparator.compare(array[j], array[j + 1]) > 0) {

                    // Swap elements if they are in the wrong order
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 8, 1, 3};
        bubbleSort(numbers);
        System.out.println(java.util.Arrays.toString(numbers));

        String[] words = {"pear", "apple", "orange"};
        bubbleSort(words, Comparator.naturalOrder());
        System.out.println(java.util.Arrays.toString(words));

        // Test Comparator with numbers in descending order
        Integer[] descendingNumbers = {5, 2, 8, 1, 3};

        bubbleSort(descendingNumbers, Comparator.reverseOrder());

        System.out.println("Descending order: "
                + java.util.Arrays.toString(descendingNumbers));
    }
}
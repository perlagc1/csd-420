
import java.util.ArrayList;
import java.util.Random;

/**
 * Name: Perla Garcia Cavazos
 * Date: November 7, 2026
 * Course: CSD 420 - Advanced Java Programming
 * Assignment: Module 3.2 - Remove Duplicates
 *
 * This program creates an ArrayList containing 50 random
 * integers between 1 and 20. It uses a generic method
 * to create a new ArrayList without duplicate values.
 */
public class Garcia_Mod3_2 {

    /**
     * Returns a new ArrayList containing only unique elements
     * from the original list, preserving their original order.
     *
     * @param list the original ArrayList
     * @param <E> the type of elements in the ArrayList
     * @return a new ArrayList without duplicates
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniqueList = new ArrayList<>();

        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Generate 50 random integers between 1 and 20.
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        // Display the original ArrayList.
        System.out.println("Original ArrayList (50 values):");
        System.out.println(originalList);

        // Remove duplicate values using the generic method.
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display the new ArrayList without duplicates.
        System.out.println("\nArrayList without duplicates:");
        System.out.println(uniqueList);

        // Display the size of both lists.
        System.out.println("\nOriginal list size: "
                + originalList.size());
        System.out.println("Unique list size: "
                + uniqueList.size());
    }
}
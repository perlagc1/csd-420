
import java.util.Iterator;
import java.util.LinkedList;

public class Garcia_Mod4_2 {

    public static void main(String[] args) {
        testLinkedList(50000);
        testLinkedList(500000);
    }

    public static void testLinkedList(int size) {
        LinkedList<Integer> numbers = new LinkedList<>();

        // Store integers in the LinkedList.
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        System.out.println("\nTesting " + size + " integers");

        // Test 1: Traverse using an Iterator.
        long startTime = System.nanoTime();

        Iterator<Integer> iterator = numbers.iterator();
        long iteratorSum = 0;

        while (iterator.hasNext()) {
            iteratorSum += iterator.next();
        }

        long iteratorTime = System.nanoTime() - startTime;

        System.out.println("Iterator time: "
                + iteratorTime / 1_000_000.0 + " ms");

        // Test 2: Traverse using get(index).
        startTime = System.nanoTime();

        long indexSum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            indexSum += numbers.get(i);
        }

        long indexTime = System.nanoTime() - startTime;

        System.out.println("get(index) time: "
                + indexTime / 1_000_000.0 + " ms");

        // Verify that both methods produce the same result.
        long expectedSum = (long) size * (size - 1) / 2;

        if (iteratorSum == indexSum && indexSum == expectedSum) {
            System.out.println("Test PASSED: Both sums match.");
        } else {
            System.out.println("Test FAILED: Results do not match.");
        }
     
/*
 * RESULTS AND EXPLANATION:
 *
 * Testing 50,000 integers:
 * Iterator time: 5.8842 ms
 * get(index) time: 1015.349 ms
 *
 * Testing 500,000 integers:
 * Iterator time: 4.0082 ms
 * get(index) time: 215931.3301 ms
 *
 * Both tests passed because the sums matched.
 *
 * The Iterator was much faster because it traverses
 * the LinkedList sequentially in O(n) time.
 *
 * The get(index) method repeatedly searches through
 * linked nodes to locate each element. Traversing
 * the entire list this way takes O(n^2) time.
 *
 * Increasing the list from 50,000 to 500,000
 * elements caused a dramatic increase in the
 * get(index) execution time.
 *
 * The Iterator times varied slightly because
 * execution times depend on JVM optimization,
 * system activity, and other runtime factors.
 *
 * These results demonstrate why an Iterator is
 * more efficient for traversing a LinkedList.
 */
    }
}
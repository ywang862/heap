import java.util.PriorityQueue;

/**
 * HeapSort Implementation
 * This demonstrates a use for priority queues
 */
public final class HeapSort {
    //Do not add any class variables

    /**
     * Sorts the inputted array
     * If a null array is passed in, throw an IllegalArgumentException
     * Assume no elements in the array are null
     * Do not create a new array.
     */
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for (String t: args) {
            priorityQueue.add(t);
        }
        for (int i = 0; i < priorityQueue.toArray().length; i++) {
            System.out.println(priorityQueue.toArray()[i]);
        }
    }
}
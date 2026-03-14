import java.util.*;
public class PQ {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public PQ() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    // Insert
    public void insert(int val) {
        minHeap.add(val);
        maxHeap.add(val);
    }

    // Get minimum
    public int getMin() {
        return minHeap.peek();
    }

    // Get maximum
    public int getMax() {
        return maxHeap.peek();
    }

    // Extract minimum
    public int extractMin() {
        int val = minHeap.poll();
        maxHeap.remove(val);
        return val;
    }

    // Extract maximum
    public int extractMax() {
        int val = maxHeap.poll();
        minHeap.remove(val);
        return val;
    }

    // Delete element
    public void delete(int val) {
        minHeap.remove(val);
        maxHeap.remove(val);
    }

    // Print heaps
    public void printHeaps() {
        System.out.println("Min Heap: " + minHeap);
        System.out.println("Max Heap: " + maxHeap);
    }

    public static void main(String[] args) {

        PQ heap = new PQ();

        heap.insert(10);
        heap.insert(4);
        heap.insert(7);
        heap.insert(1);
        heap.insert(9);

        System.out.println("After Insert:");
        heap.printHeaps();

        System.out.println("\nMin element: " + heap.getMin());
        System.out.println("Max element: " + heap.getMax());

        System.out.println("\nExtract Min: " + heap.extractMin());
        heap.printHeaps();

        System.out.println("\nExtract Max: " + heap.extractMax());
        heap.printHeaps();

        heap.delete(7);
        System.out.println("\nAfter deleting 7:");
        heap.printHeaps();
    }
}

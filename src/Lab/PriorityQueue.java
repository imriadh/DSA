package Lab;
import java.util.Scanner;

public class PriorityQueue {

    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Helper method to swap two elements in the array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // To heapify a subtree rooted at index i to create a max heap
    private void maxHeapify(int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && heap[l] > heap[largest]) {
            largest = l;
        }

        if (r < n && heap[r] > heap[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(n, largest);
        }
    }

    // To heapify a subtree rooted at index i to create a min heap (for priority queue)
    private void minHeapify(int n, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && heap[l] < heap[smallest]) {
            smallest = l;
        }

        if (r < n && heap[r] < heap[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(n, smallest);
        }
    }

    // Performs Heap Sort in ascending order using a Max Heap
    public void heapSortAscending() {
        // Build a max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(size, i);
        }

        // Extract elements one by one from the heap
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            maxHeapify(i, 0); // Re-heapify the reduced heap
        }
    }

    // Builds a Min Heap, representing a Priority Queue where smallest is highest priority
    public void buildMinPriorityQueue() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(size, i);
        }
    }

    // Deletes the root element (highest priority) and re-heapifies
    public void deleteRoot() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return;
        }
        heap[0] = heap[size - 1]; // Move the last element to the root
        size--; // Decrease the size of the heap
        minHeapify(size, 0); // Re-heapify to maintain the min-heap property
    }

    // Adds a new element to the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        // Heapify-up to maintain the heap property after insertion (for max heap)
        while (current > 0 && heap[current] > heap[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public void printHeap(String message) {
        System.out.println(message);
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers you want to take: ");
        int n = scanner.nextInt();
        PriorityQueue hp = new PriorityQueue(n);

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            hp.heap[i] = scanner.nextInt();
        }
        hp.size = n;

        System.out.println("Initial values: ");
        hp.printHeap("");

        System.out.println("Enter 'heap-sort', 'priority-queue', or 'delete':");
        while (true) {
            String s = scanner.next();
            if (s.equalsIgnoreCase("heap-sort")) {
                hp.heapSortAscending();
                hp.printHeap("Sorted Values Are!");
            } else if (s.equalsIgnoreCase("priority-queue")) {
                hp.buildMinPriorityQueue();
                hp.printHeap("Priority Queue (Min Heap)!");
            } else if (s.equalsIgnoreCase("delete")) {
                hp.deleteRoot();
                hp.printHeap("After deleting the root (smallest) element:");
            } else {
                break;
            }
        }
        scanner.close();
    }
}
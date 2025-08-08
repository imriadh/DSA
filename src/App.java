import java.util.ArrayList;
import java.util.List;

public class HeapList {
    private List<Integer> heap;

    public HeapList() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Delete the root (max element) from the heap
    public Integer delete() {
        if (heap.isEmpty()) {
            return null;
        }
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    // Heapify down from the given index
    private void heapifyDown(int index) {
        int size = heap.size();
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < size && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Print the heap as a list
    public void print() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        HeapList hp = new HeapList();
        hp.insert(25);
        hp.insert(40);
        hp.insert(10);
        hp.insert(30);
        hp.print(); // Should print the heap as a list

        System.out.println("Deleted root: " + hp.delete());
        hp.print(); // Print after deletion
    }
}

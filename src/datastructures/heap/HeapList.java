package datastructures.heap;

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

    public void print() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return;
        }
        System.out.print("Heap: ");
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i));
            if (i < heap.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // Simple delete method: remove root and re-heapify
    public Integer delete() {
        if (heap.isEmpty()) return null;
        int removed = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return removed;
    }

    private void heapifyDown(int i) {
        int size = heap.size();
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);
            int largest = i;
            if (left < size && heap.get(left) > heap.get(largest)) largest = left;
            if (right < size && heap.get(right) > heap.get(largest)) largest = right;
            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
    HeapList hp = new HeapList();
    hp.insert(25);
    hp.insert(40);
    hp.insert(10);
    hp.insert(30);
    hp.print(); // Should print the heap as a list
    System.out.println("Deleted root: " + hp.delete());
    hp.print();
    }
}

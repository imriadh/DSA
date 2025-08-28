package Lab;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // Create a min-heap of size k
        int[] minHeap = new int[k];
        
        // Initialize the heap with the first k elements
        for (int i = 0; i < k; i++) {
            minHeap[i] = nums[i];
        }
        
        // Heapify the initial k elements
        for (int i = (k / 2) - 1; i >= 0; i--) {
            heapify(minHeap, k, i);
        }
        
        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap[0]) { // If current element is larger than the root
                minHeap[0] = nums[i];  // Replace the root
                heapify(minHeap, k, 0); // Heapify to maintain the min-heap property
            }
        }
        
        // The root of the heap is the kth largest element
        return minHeap[0];
    }

    // Heapify function to maintain the min-heap property
    private static void heapify(int[] heap, int heapSize, int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Find the smallest among the node and its children
        if (leftChild < heapSize && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < heapSize && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        // If the smallest is not the current node, swap and continue heapifying
        if (smallest != index) {
            swap(heap, index, smallest);
            heapify(heap, heapSize, smallest);
        }
    }

    // Swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(findKthLargest(nums1, k1)); // Output: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(findKthLargest(nums2, k2)); // Output: 4
    }
}
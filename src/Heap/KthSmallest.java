import java.util.*;

public class KthSmallestElement {

    public static int findKthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.offer(num);  // Add current element to heap

            // size > k, remove the largest (top of max-heap)
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Top of the heap is the k-th smallest
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int result = findKthSmallest(arr, k);
        System.out.println("The " + k + " smallest element is: " + result);
    }
}
package Heap;
import java.util.*;
public class SortKSortedArray {
    public static ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            q.offer(arr[i]);

            // Maintain a heap of size k+1
            if (q.size() > k) {
                list.add(q.poll());
            }
        }

        // Add remaining elements
        while (!q.isEmpty()) {
            list.add(q.poll()); //q.poll() -> top
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int num = arr.length;
        int k = 3;

        ArrayList<Integer> sorted = nearlySorted(arr, num, k);

        System.out.println("Sorted array:");
        for (int val : sorted) {
            System.out.print(val + " ");
        }
    }
}

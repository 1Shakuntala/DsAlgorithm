package Heap;
import java.util.*;
public class KClosestNumber {
    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 22, 40};
        int k = 15;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );

        for (int val : arr) {
            minHeap.add(new int[]{val, Math.abs(val - k)});
        }

        int closest = minHeap.peek()[0];
        System.out.println("Closest value to " + k + " is: " + closest);
    }
}

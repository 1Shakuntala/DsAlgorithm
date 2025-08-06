package SlidingWindow;
import java.util.*;


public class FirstNegativeIntInWindow {
    public static List<Integer> findFirstNegative(int[] arr, int k){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> negative = new LinkedList<>();

        int i=0, j = 0;

        while (j < arr.length) {
            // Step 1: Add to queue if negative
            if (arr[j] < 0) {
                negative.add(arr[j]);
            }

            // Step 2: Check if window size is less than k
            if (j - i + 1 < k) {
                j++;
            }
            // Step 3: Window size == k
            else if (j - i + 1 == k) {
                // Add result
                if (negative.isEmpty()) {
                    res.add(0);
                } else {
                    res.add(negative.peek());
                }

                // Remove element going out of window from queue
                if (!negative.isEmpty() && arr[i] == negative.peek()) {
                    negative.poll();
                }

                // Slide the window
                i++;
                j++;
            }
        }

        return res;

    }
    public static void main(String[] args){
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 18};
        int k=3;
        List<Integer> result = findFirstNegative(arr, k);
        System.out.println(result);
    }
}

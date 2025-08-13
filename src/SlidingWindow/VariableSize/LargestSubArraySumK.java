package SlidingWindow.VariableSize;

public class LargestSubArraySumK {
    public static int largestSubarrayWithSumK(int[] arr, int K) {
        int start = 0;
        int sum = 0;
        int maxLen = 0;

        for (int end = 0; end < arr.length; end++) {
            // Add current element to the window
            sum += arr[end];

            // Shrink window if sum is greater than K
            while (sum > K) {
                sum -= arr[start];
                start++;
            }

            // Check if we found a valid subArray
            if (sum == K) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        int K = 4;
        System.out.println("Largest subarray length: " + largestSubarrayWithSumK(arr, K));
    }
}

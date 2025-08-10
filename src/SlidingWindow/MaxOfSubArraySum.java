package SlidingWindow;

public class MaxOfSubArraySum {

    public static int MaxSumSubArrayOfSizeK(int[] arr, int k) {
        int i = 0, j = 0, sum = 0;
        int mx = Integer.MIN_VALUE;
        int size = arr.length;

        if (k > size) {
            System.out.println("Window size k is greater than array size.");
            return -1;
        }

        while (j < size) {
            sum += arr[j];

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                mx = Math.max(mx, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }

        return mx;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int result = MaxSumSubArrayOfSizeK(arr, k);
        if (result != -1) {
            System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
        }
    }
}
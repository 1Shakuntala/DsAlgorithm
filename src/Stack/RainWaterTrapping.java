package Stack;

public class RainWaterTrapping {
    public static int trap(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];   // max height to the left of i
        int[] rightMax = new int[n];  // max height to the right of i
        int[] water = new int[n];     // water above each bar

        // Step 1: Fill leftMax
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Step 2: Fill rightMax
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Step 3: Calculate water at each index {and if building present then subtract to calculate water level}
        for (int i = 0; i < n; i++) {
            water[i] = Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        // Step 4: Sum up water
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += water[i];
        }

        return sum;
    }
    public static void main(String[] args) {

        int[] arr = {4,2,0,3,2,5};
        System.out.print("Water Trapped: "+trap(arr));
    }
}

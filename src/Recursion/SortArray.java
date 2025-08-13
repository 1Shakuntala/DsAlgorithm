package Recursion;

public class SortArray {

    // Insert element in correct position in sorted array
    static void insert(int[] arr, int n) {


        if (n <= 0 || arr[n] >= arr[n - 1]) {
            return;
        }

        // Swap with previous
        int temp = arr[n];
        arr[n] = arr[n - 1];
        arr[n - 1] = temp;

        // Move back to check previous positions
        insert(arr, n - 1);
    }

    // Sort function
    static void sort(int[] arr, int n) {
        // Base case: single element is already sorted
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        sort(arr, n - 1);

        // Insert nth element into correct position
        insert(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        sort(arr, arr.length);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

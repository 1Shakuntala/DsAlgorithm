package Recursion;

public class SortArray {

    public static void insert(int[] arr, int n){
        if(n<=0 || arr[n]>=arr[n-1]){
            return;
        }
        //swap
        int temp = arr[n-1];
        arr[n-1] = arr[n];
        arr[n] = temp;
        insert(arr, n-1);
    }
    public static void sort(int[] arr,int n){
        if(n<=1) return;
        sort(arr, n-1);
        insert(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        sort(arr, arr.length);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

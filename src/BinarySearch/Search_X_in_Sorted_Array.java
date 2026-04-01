package BinarySearch;

public class Search_X_in_Sorted_Array {

    public static int Search_X(int[] a, int target){
        int n=a.length;
        int low=0, high=n-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==target) return mid;
            else if(target>a[mid]) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target  = 6;
        System.out.println(Search_X(a, target));
    }
}

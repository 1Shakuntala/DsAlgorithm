package BinarySearch;

public class Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int n = nums.length;

        int idx = min_element(nums);

        if (nums[idx] == target) return idx;

        if (idx == 0) {
            return binarySearch(nums, 0, n - 1, target);
        }

        if (target >= nums[0]) {
            return binarySearch(nums, 0, idx - 1, target);
        }

        return binarySearch(nums, idx, n - 1, target);
    }

    public int min_element(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;

        // Optional optimization
        if (nums[start] <= nums[end]) return 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            }

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array obj = new Search_in_Rotated_Sorted_Array();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int result = obj.search(nums, target);
        System.out.println("Index: " + result); // Expected: 4
    }
}
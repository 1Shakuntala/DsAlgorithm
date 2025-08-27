package Arrays;
import java.util.*;


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = target-nums[i];
            if (m.containsKey(num)) {
                return new int[] { m.get(num), i };
            }
            m.put(nums[i], i);
        }
        return new int[] {};
    }
}

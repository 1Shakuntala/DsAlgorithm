package SlidingWindow.VariableSize;

import java.util.*;

public class LongestSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0, end = 0, maxLen = 0;
        HashSet<Character> window = new HashSet<>();

        while (end < s.length()) {
            char rightChar = s.charAt(end);

            // If character already in set, shrink from the left
            while (window.contains(rightChar)) {
                window.remove(s.charAt(start));
                start++;
            }

            // Add the current character to the set
            window.add(rightChar);

            // Update max length
            maxLen = Math.max(maxLen, end - start + 1);

            // Move window forward
            end++;
        }

        return maxLen;
        

    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = lengthOfLongestSubstring(str);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}

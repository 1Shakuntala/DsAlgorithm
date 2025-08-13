package SlidingWindow.FixedSize;

import java.util.*;

public class OccurenceOfAnagram {

    public static int countAnagrams(String str, String ptr) {
        Map<Character, Integer> ptrCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        for (char c : ptr.toCharArray()) {
            ptrCount.put(c, ptrCount.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int i = 0, j = 0;
        int windowSize = ptr.length();
        while (j < str.length()) {
            // Add current character to windowCount
            char ch = str.charAt(j);
            windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);

            // If window size is less than ptr length, just expand window
            if (j - i + 1 < windowSize) {
                j++;
            }
            // If window size matches ptr length
            else if (j - i + 1 == windowSize) {
                // Step 3: Check if window is an anagram
                if (windowCount.equals(ptrCount)) {
                    count++;
                }

                // Step 4: Slide the window
                char leftChar = str.charAt(i);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (windowCount.get(leftChar) == 0) {
                    windowCount.remove(leftChar);
                }

                i++;
                j++;
            }
        }

        return count;
    }

        public static void main(String[] args) {
            String str = "forxxorfxdofr";
            String ptr = "for";

            int result = countAnagrams(str, ptr);
            System.out.println("Total anagrams: " + result);
        }
}

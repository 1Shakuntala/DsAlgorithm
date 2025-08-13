package SlidingWindow.VariableSize;

import java.util.*;
public class LongestSubstringKUniqueChar {

    public static int longestLengthSubstring(String s, int k){
        if(s==null || s.length()==0 || k<=0){
            return 0;
        }
        int i=0, j=0, mxLen=0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        while(j<s.length()){
            char rightChar = s.charAt(j);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0)+1);

            while(charCount.size()>k){
                char leftChar = s.charAt(i);
                charCount.put(leftChar, charCount.getOrDefault(leftChar,0)-1);
                if(charCount.get(leftChar)==0){
                    charCount.remove(leftChar);
                }
                i++;
            }
            if (charCount.size() == k) {
                mxLen = Math.max(mxLen, j - i + 1);
            }

            j++;
        }
        return mxLen;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k=3;
        int length = longestLengthSubstring(str, k);
        System.out.println("Length of longest substring with " + k + " unique characters: is " + length);
    }
}

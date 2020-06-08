package com.leetcode.blackdog;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int count = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                count = Math.max(count, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }

        return count;
    }
}

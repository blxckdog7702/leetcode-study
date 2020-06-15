package com.leetcode.blackdog;

public class IsSubSequence {

    public static void main(String[] args) {
        IsSubSequence isSubSequence = new IsSubSequence();
        System.out.println(isSubSequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubSequence.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}

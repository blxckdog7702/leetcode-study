package com.baemin.blackdog;

public class BinaryTree {

    private StringBuilder b = new StringBuilder();
    private char[] arr;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println(tree.solution("ABCDEFG"));
    }

    private String solution(String input) {
        arr = input.toCharArray();
        traverse(1);
        return b.toString();
    }

    private void traverse(int n) {
        try {
            char ch = arr[n - 1];
            traverse(n * 2);
            traverse(n * 2 + 1);
            b.append(ch);
        } catch (ArrayIndexOutOfBoundsException e) {
            // ignore
        }
    }
}
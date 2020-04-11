package com.leetcode.blackdog;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        MyStack stack1 = new MyStack();
        MyStack stack2 = new MyStack();

        for(int i = 0; i < S.length(); i++) {
            stack1.push(S.charAt(i));
        }

        for(int i = 0; i < T.length(); i++) {
            stack2.push(T.charAt(i));
        }

        if(stack1.size() != stack2.size()) {
            return false;
        }

        while(!stack1.empty()) {
            if(stack1.pop() != stack2.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String S = "a##c", T = "#a#c";
        String S = "a#c", T = "b";

        BackspaceStringCompare problem = new BackspaceStringCompare();
        System.out.println(problem.backspaceCompare(S, T));
    }
}

class MyStack extends Stack<Character> {

    @Override
    public Character push(Character character) {
        if(character == '#') {
            return pop();
        }

        return super.push(character);
    }

    @Override
    public synchronized Character pop() {
        if(this.isEmpty()) {
            return null;
        }

        return super.pop();
    }
}
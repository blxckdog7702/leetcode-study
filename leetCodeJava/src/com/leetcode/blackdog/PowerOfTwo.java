package com.leetcode.blackdog;

public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo2(1024));

    }

    public boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }

        int num = n;

        while(num % 2 == 0) {
            num = num / 2;
        }

        return num == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if(n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
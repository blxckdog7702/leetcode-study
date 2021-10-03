package com.baemin.blackdog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PocketMoney {

    public static void main(String[] args) {
        PocketMoney pocketMoney = new PocketMoney();

        int[][] input = {{100, 3}, {200, 1}, {50, 2}};
        int[][] input2 = {{2500, 3}, {700, 5}};

        System.out.println(pocketMoney.solution(input2));
    }

    private int solution(int[][] input) {
        List<Money> list = new ArrayList<>();

        for (int[] ints : input) {
            list.add(new Money(ints[0], ints[1]));
        }

        List<Money> sorted = list.stream().sorted(Comparator.comparingInt(Money::getAmount)
                .reversed())
                .collect(Collectors.toList());

        int a = 0, b = 0;

        for (Money money : sorted) {
            while(money.count != 0) {
                if (a < b) {
                    a += money.amount;
                } else {
                    b += money.amount;
                }
                money.count--;
            }
        }

        return Math.abs(a - b);
    }
}

class Money {
    int amount;
    int count;

    public Money(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }
}

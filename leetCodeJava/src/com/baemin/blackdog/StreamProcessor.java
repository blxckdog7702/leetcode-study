package com.baemin.blackdog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamProcessor {

    public static void main(String[] args) {
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.lines()
                .filter(n -> (n.length() >= 5) && (n.length() < 10))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

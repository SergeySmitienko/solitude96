package com.tsystems.javaschool.tasks;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Subsequence s = new SubsequenceImpl();
        boolean b = s.find(Arrays.asList("A","ABC","B","C","D"),Arrays.asList("BD","A","C","ABC","B","M","D","M","C","DC","D"));
        System.out.println(b);
    }
}

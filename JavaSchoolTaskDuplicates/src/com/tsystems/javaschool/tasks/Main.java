package com.tsystems.javaschool.tasks;


import java.io.File;

public class Main {
    public static void main(String[] args) {
        DuplicateFinder d = new DuplicateFinderImpl();
        boolean ok = d.process(new File("a.txt"),new File("b.txt"));
        System.out.println(ok);
    }
}

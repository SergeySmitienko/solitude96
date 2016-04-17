package com.tsystems.javaschool.tasks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by skeep on 13.01.2016.
 */
public class Main {
    public static void main(String[] args) {
    Calculator c = new CalculatorImpl();
        System.out.println(c.evaluate("(-22323.3-3232.223))*4.2424"));
    }
}

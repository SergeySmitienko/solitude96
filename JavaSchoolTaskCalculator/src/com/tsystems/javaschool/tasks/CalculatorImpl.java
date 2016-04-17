package com.tsystems.javaschool.tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Deque;
import java.util.LinkedList;

public class CalculatorImpl implements Calculator {

    @Override
    public String evaluate(String statement) {
        StringBuilder postfixStr = new StringBuilder(); // Create String to implement postfix notation
        Deque<Character> stack = new LinkedList(); // Create Stack to implement postfix notation
        int marker = 0;
        while (marker < statement.length()){
            char symb = statement.charAt(marker);
           if (symb >= '0' && symb <= '9'){
               int startValue = marker;
               //int endValue = startValue;
               marker++;
               while ((symb >= '0' && symb <= '9' || symb =='.') && marker < statement.length()){
                   symb = statement.charAt(marker);
                   marker++;
               }
               if (marker == statement.length())
               marker++;

               marker--;
               int endValue = marker;

               String value = statement.substring(startValue,endValue);
               postfixStr.append(value);
               postfixStr.append(" ");
               //marker++;

           } else {
               switch (symb){
                   case '(':
                       stack.add(symb);
                       marker++;
                       break;
                   case ')':
                       while (stack.size() > 0 && stack.getLast() != '(') {
                            postfixStr.append(stack.peekLast());
                            postfixStr.append(" ");
                            stack.pollLast();
                       }
                       if (stack.size() == 0){
                           return null;
                       } else {
                           stack.pollLast();
                       }
                       marker++;
                       break;
                   case '*':
                   case '/':
                       stack.add(symb);
                       marker++;
                       break;
                   case '+':
                   case '-':
                       if( marker == 0 || (statement.charAt(marker-1) == '(' && (statement.charAt(marker+1) >= '0' && statement.charAt(marker+1) <= '9') )){
                            postfixStr.append(symb);
                           marker++;
                       } else {
                           while (stack.size() > 0 && priority(symb) < priority(stack.peekLast())) {
                               postfixStr.append(stack.peekLast());
                               postfixStr.append(" ");
                               stack.pollLast();
                           }
                           stack.add(symb);
                           marker++;
                           break;
                       }
               }
           }

        }
        while (stack.size() > 0) {
            char symb = stack.peekLast();
            if (symb == ')' || (symb == '('))
                return null;
            postfixStr.append(symb);
            postfixStr.append(" ");
            stack.pollLast();
        }

    return  stackMachine(postfixStr);
    }
    int priority (char operation){
        if (operation == '+' || operation == '-')
            return 0;
        if (operation == '*' || operation == '/')
            return 1;
        return -1;

    }
    String stackMachine (StringBuilder postfixStr){
        Deque<String> stack = new LinkedList<>();
        int marker = 0;

        while (marker < postfixStr.length()){
            String str = new String();
            int start = marker;
            while (postfixStr.charAt(marker)!=' '){
                //str.append(postfixStr.charAt(marker));
                marker++;
            }
            str = postfixStr.substring(start,marker);
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                String op2 = stack.getLast();
                stack.pollLast();
                String op1 = stack.getLast();
                stack.pollLast();
                Double op1Double = Double.valueOf(op1);
                Double op2Double = Double.valueOf(op2);
                Double result = 0.0;

                switch (str){
                    case "+":
                        result = op1Double + op2Double;
                        break;
                    case "-":
                        result = op1Double - op2Double;
                        break;
                    case "*":
                        result = op1Double * op2Double;
                        break;
                    case "/":
                        result = op1Double / op2Double;
                        break;
                }
                stack.add(String.valueOf(new BigDecimal(result).setScale(4, RoundingMode.HALF_UP)));
            } else {
                stack.add(str);
            }

            marker++;
        }
        return new String(stack.peekLast());
    }
}

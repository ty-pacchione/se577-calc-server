package main;

import operations.Addition;
import operations.Multiplication;
import operations.Number;

public class Main {
    public static void main(String[] args) {
        Number num1 = new Number(3);
        Number num2 = new Number(4);
        Number num3 = new Number(5);

        Addition add = new Addition(num1, num2);
        Multiplication mult = new Multiplication(add, num3);

        System.out.println(mult.evaluate());
    }
}
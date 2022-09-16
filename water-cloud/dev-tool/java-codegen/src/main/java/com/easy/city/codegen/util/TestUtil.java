package com.easy.city.codegen.util;

import java.util.Random;

public class TestUtil {
    public static void main(String[] args) {
        Random r = new Random();
        double d = r.nextDouble();
        double randomResult = d * (300 - 100) + 100;
        int amount = (int) (randomResult);
        System.out.println(d);
        System.out.println(randomResult);
        System.out.println(amount);
    }
}

package com.habsida;

import java.io.ByteArrayInputStream;

public class Test {
    final static int MIN_VALUE = -10;
    final static int MAX_VALUE = 20;
    final static int COUNT_OF_DELAY = 10;
    
    public static void runTest() {

        StringBuilder str = null;
        int sum = 0;

        for (int i = 1; i <= COUNT_OF_DELAY; i++) {
            int n = getRandom();
            int x;
            sum = 0;
            str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                x = getRandom();
                sum += x;
                str
                    .append(x)
                    .append(", ");
            }
            x = getRandom();
            sum += x;
            str.append(x);
            System.out.println("Test " + i);
            System.out.println(str.toString());


            int result = 0;
            try (ByteArrayInputStream fin = new ByteArrayInputStream(str.toString().getBytes())) {
                result = Solution.sumOfStream(fin);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Expected sum is: " + sum + ", returned sum is: " + result + ", pass: " + (sum == result));
        }

    }

    public static int getRandom() {
        return (int) ((Math.random() * (MAX_VALUE - MIN_VALUE)) + MIN_VALUE);
    }
}

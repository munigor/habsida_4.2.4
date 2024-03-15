package com.habsida;

import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static int sumOfStream (InputStream fin) throws IOException {
        int sum = 0;
        StringBuilder number = new StringBuilder();
        int ch = -1;

        while ((ch = fin.read()) != -1) {
            if(Character.isDigit(ch)) {
                number.append((char) ch);
            } else if (number.isEmpty() && ((char) ch) == '-') {
                number.append((char) ch);
            } else if (!number.isEmpty()) {
                sum += Integer.parseInt(number.toString());
                number = new StringBuilder();
            }
        }

        if(!number.isEmpty()) {
            sum += Integer.parseInt(number.toString());
        }

        return sum;
    }
}

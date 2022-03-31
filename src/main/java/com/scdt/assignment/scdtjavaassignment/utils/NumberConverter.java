package com.scdt.assignment.scdtjavaassignment.utils;

import java.util.regex.Pattern;

public class NumberConverter {
    static String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static int SCALE = 62;

    public static String from10baseTo62base(int input) {
        if (input < 62) {
            return String.valueOf(CHARS.charAt(input));
        }
        StringBuilder sb = new StringBuilder();
        int remainder;
        int val = input;
        while (Math.abs(val) > SCALE - 1) {
            //从最后一位开始进制转换，取转换后的值，最后反转字符串
            remainder = Long.valueOf(val % SCALE).intValue();
            sb.append(CHARS.charAt(remainder));
            val = val / SCALE;
        }
        //获取最高位
        sb.append(CHARS.charAt(Long.valueOf(val).intValue()));
        return sb.reverse().toString();
    }

    public static int from62baseTo10base(String input) {
        int val = 0;
        int base = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(input.length() - 1 - i);
            val += CHARS.indexOf(c) * base;
            base = base * SCALE;

        }
        return val;
    }
}

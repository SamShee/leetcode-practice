package com.kafoon.leetcode.string;


import java.util.HashMap;
import java.util.Map;

public class Num_13_Roman2Int {

    public static void main(String[] args) {
        String s = "MMCCCXCIX";
        int result = romanToInt(s);
        System.out.println("result = " + result);

        int res = romanToInt2(s);
        System.out.println("res = " + res);
    }

    private static int romanToInt2(String s) {

        int length = s.length();
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < length; i++) {
            int num = getValue(s.charAt(i));
            if(preNum < num){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char c) {

        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    private static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if(i < length - 1 && "IXC".indexOf(ch) > -1 && "VXLCDM".indexOf(s.charAt(i+1)) > -1){
                char ch2 = s.charAt(i+1);
                if(ch == 'I' && ch2 == 'V'){
                    sum += 4;
                    i++;
                }else if(ch == 'I' && ch2 == 'X'){
                    sum += 9;
                    i++;
                }else if(ch == 'X' && ch2 == 'L'){
                    sum += 40;
                    i++;
                }else if(ch == 'X' && ch2 == 'C'){
                    sum += 90;
                    i++;
                }else if(ch == 'C' && ch2 == 'D'){
                    sum += 400;
                    i++;
                }else if(ch == 'C' && ch2 == 'M'){
                    sum += 900;
                    i++;
                }else{
                    sum = map.get(ch) + sum;
                }
            }else{
                int count = map.get(ch);
                sum += count;
            }
        }

        return sum;
    }


}

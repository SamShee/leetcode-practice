package com.kafoon.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Num_1507_ParseDate {

    public static void main(String[] args) {
        String inputStr = "6th Jun 1933";
        String outputStr = parseStringToFormat(inputStr);

        System.out.println("outputStr = " + outputStr);
    }

    private static String parseStringToFormat(String inputStr) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        String[] arrs = inputStr.split(" ");
        String dayStr = arrs[0];
        String monthStr = arrs[1];
        String year = arrs[2];

        String month = map.get(monthStr);

        String day = dayStr.substring(0, dayStr.length() - 2);
        if(day.length() == 1){
            day = 0 + day;
        }
        return year + "-" + month + "-" + day;
    }
}

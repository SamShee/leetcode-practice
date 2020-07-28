package com.kafoon.leetcode.string;

public class Num_14_MaxPrefix {

    public static void main(String[] args) {
//        String[] arrs = {"flower", "flow", "flight"};
        String[] arrs = {"aa", "a"};
        String prefix = longestCommonPrefix(arrs);
        System.out.println("prefix = " + prefix);
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            int clength = strs[i].length();
            if(clength < length){
                length = clength;
            }
        }

        StringBuffer sb = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if(ch != strs[j].charAt(i)){
                    flag = false;
                    break;
                }

            }
            if(flag){
                sb.append(ch);
            }else{
                break;
            }
        }

        return sb.toString();

    }

}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Num_20_ValidBrackets
 * Author:   Stones
 * Date:     2020/7/29 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kafoon.leetcode.string;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Stones
 * @create 2020/7/29
 * @since 1.0.0
 */
public class Num_20_ValidBrackets {

    public static void main(String[] args) {
        String str1 = "({{[]})";
        boolean flag = isValid(str1);
        System.out.println("flag = " + flag);
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        return true;
    }
}

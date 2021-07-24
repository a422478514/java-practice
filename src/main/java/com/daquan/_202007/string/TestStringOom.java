package com.daquan._202007.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试java的字符串常量池在堆中
 */
public class TestStringOom {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String str = "abcd";
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            str += str;
            list.add(str);
            System.out.println(i);
        }
    }
}

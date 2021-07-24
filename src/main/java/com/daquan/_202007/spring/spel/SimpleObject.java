package com.daquan._202007.spring.spel;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试spel支持自动类型转换
 */
public class SimpleObject {
    public static List<Boolean> list = new ArrayList<Boolean>();
    static {
        list.add(true);
    }
}

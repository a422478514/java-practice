package com.daquan._202007._01.string;

/**
 * 尽管在输出中调用intern方法并没有什么效果，但是实际上后台这个方法会做一系列的动作和操作。
 * 在调用”ab”.intern()方法的时候会返回”ab”，但是这个方法会首先检查字符串池中是否有”ab”这个字符串，
 * 如果存在则返回这个字符串的引用，否则就将这个字符串添加到字符串池中，然会返回这个字符串的引用。
 */
public class TestIntern {
    public static void main(String[] args) {
        String sb = new StringBuilder("daquan").append("b").toString();
        String intern = sb.intern();//将sb保存到字符串常量池，然会返回这个字符串的引用
        System.out.println( intern == sb);//true
        String java = new StringBuilder("ja").append("va").toString();
        String javaIntern = java.intern();//返回常量池中已有的"java"
        System.out.println(javaIntern == java);//false
    }
}

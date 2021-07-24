package com.daquan._202007.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

public class MySpel {

    public static ExpressionParser parser = new SpelExpressionParser();

    //使用Spring的表达接口 表达式求值
    public static void test1(){
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
    //使用Spring的表达接口 调用方法
    public static void test2(){
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
    //SpEL还支持使用标准的“.”符号，即嵌套属性prop1.prop2.prop3和属性值的设置
    public static void test3(){
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        Integer message = (Integer) exp.getValue();
        System.out.println(message);
    }
    //搜索对象中的属性值
    public static void test4(){
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("BC");
        EvaluationContext context = new StandardEvaluationContext(c);
        int EPOCH_OFFSET = (int) exp.getValue(context);
        System.out.println(EPOCH_OFFSET);
    }
    //默认类型转换
    public static void test5(){
        SimpleObject object = new SimpleObject();
        StandardEvaluationContext simpleContext = new StandardEvaluationContext(object);
        parser.parseExpression("list[0]").setValue(simpleContext,"false");
        System.out.println(SimpleObject.list.get(0));
    }
    //用一个parser configuration object去配置SpEL解析器是可能的, （org.springframework.expression.spel.SpelParserConfiguration）.
    //配置 对象控制的一些表达组件的行为。例如，如果数据为 索引到指定索引处的数组或集合的元素是null 它可以自动地创建的元素。
    //当用表达式组合一个链式属性引用时这将非常有用. 如果索引到一个数组或列表 并指定一个索引超出数组的当前大小或
    //自动增长的数组或队列去容纳
    public static void test6(){
        // Turn on:
        // - auto null reference initialization
        // - auto collection growing
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);
        ExpressionParser parser = new SpelExpressionParser(config);
        Expression expression = parser.parseExpression("list[3]");
        Demo demo = new Demo();
        System.out.println(demo.list == null);
        Object o =  expression.getValue(demo);
        System.out.println(123);
        System.out.println(demo.list.size());
        // demo.list will now be a real collection of 4 entries
        // Each entry is a new empty String
    }

}

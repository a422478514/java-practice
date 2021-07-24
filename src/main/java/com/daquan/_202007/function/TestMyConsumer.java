package com.daquan._202007.function;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestMyConsumer {

    public static void apply(String s){
        System.out.println(s.charAt(1));
    }

    //静态方法引用
    @Test
    public void test1(){

        Consumer<String> consumer = System.out::println;
        consumer.accept("接受的数据");
    }
    //费静态方法引用
    @Test
    public void test2(){
        Set<String> set = new HashSet<String>();
        Consumer<String> cs = set::add;
        cs.accept("aa");
        System.out.println(set.size());
    }

    @Test
    public void test3(){
        List<String> list = new ArrayList<String>();
        Consumer<String> consumer = x ->{
            if(!x.equals("")){
                list.add(x);
            }
        };
        consumer = consumer.andThen(x -> list.removeIf(y->y.contains("b")));
        Stream.of(
                "a",
                "b",
                "c",
                "d",
                "e"
        ).forEach(consumer);
        System.out.println(Arrays.toString(list.toArray()));
    }
    static class Person{
        private int age;
        private String name;
        public Person(int age,String name){
            this.age = age;
            this.name = name;
        }
    }

    @Test
    public void test4(){
        List<Person> lisiList = new ArrayList<>();
        Consumer <Person> consumer  =  x -> {
            if (x.name.equals("lisi")){
                lisiList.add(x);
            }
        };

        consumer = consumer.andThen(
                x -> lisiList.removeIf(y -> y.age < 23)
        );

        Stream.of(
                new Person(21,"zhangsan"),
                new Person(22,"lisi"),
                new Person(23,"wangwu"),
                new Person(24,"wangwu"),
                new Person(23,"lisi"),
                new Person(26,"lisi"),
                new Person(26,"zhangsan")
        ).forEach(consumer);
    }

    public static void main(String[] args) {


    }
}

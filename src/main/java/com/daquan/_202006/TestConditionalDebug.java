package com.daquan._202006;

/**
 * 测试条件断点
 * 本人csdn：https://blog.csdn.net/u010285974
 */
public class TestConditionalDebug {

    //断点调试监控的变量
    private static int v = 1;

    public static void main(String[] args) {
        //1、无条件断点 博客地址：https://blog.csdn.net/u010285974/article/details/107038220
        //直接在下方代码左侧打断点
        System.out.println(123);
        for (int i = 0; i < 100; i++) {
            //2、条件断点 博客地址：https://blog.csdn.net/u010285974/article/details/107035630
            //在下方代码左侧打上断点，并在断点上右键并输入 i==88，DEBUG运行后会直接跳到 i=88处
            System.out.println(i);
            //3、异常断点调试，点击左下角View BreakPoints，在弹出界面配置想要监听的异常，取消Any exception。 博客地址：https://blog.csdn.net/u010285974/article/details/107038886
            if(i==10) throw new RuntimeException();
            //4、方法断点调试 博客地址：https://blog.csdn.net/u010285974/article/details/107039404
            print(i);
            //5、变量断点调试 博客地址：https://blog.csdn.net/u010285974/article/details/107039587
            opV();
        }
        System.out.println(234);
    }

    public static void print(int i){
        System.out.println("hello:"+i);
    }

    public static void opV(){
        v++;
    }
}

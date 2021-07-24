package com.daquan._202007.async;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/7/14
 */
public class TestThread extends Thread
{
    @Override
    public void run() {
        System.out.println(this.getName() + "子线程开始");
        try {
            // 子线程休眠五秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "子线程结束");
    }
}

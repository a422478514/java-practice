package com.daquan._202007._01.simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 2020年07月27日 新增判断dateformat是非线程安全的
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = "2020-10-10";
        String date2 = "2020-10-11";
        String date3 = "2020-10-12";
        CountDownLatch count = new CountDownLatch(3);

        new Thread(()->{
            try {
                count.countDown();
                count.await();
                Date date11 = simpleDateFormat.parse(date1);
                System.out.println(date11.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                count.countDown();
                count.await();
                Date date11 = simpleDateFormat.parse(date2);
                System.out.println(date11.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                count.countDown();
                count.await();
                Date date11 = simpleDateFormat.parse(date3);
                System.out.println(date11.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

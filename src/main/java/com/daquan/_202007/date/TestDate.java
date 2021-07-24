package com.daquan._202007.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/2/2
 */
public class TestDate {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("", dateTimeFormatter);
        String str2 =  dateTimeFormatter.format(date);
    }
}

package com.daquan._202006;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/1/3
 */
public class HandleTrainTxt {

    static String inputPath = "/Users/zhangdaquan/home/buaa/baiduyun/机器学习基础（AI）期末大作业/Fires_压缩/train/xml/";

    //JPEGImages/0027.jpg Annotations/0027.xml

    public static void main(String[] args) throws IOException {

        //读取输入文件夹
        //遍历每个图片文件获取文件名，大小 以及对应的xml
        File inputFd = new File(inputPath);
        File[] f = inputFd.listFiles();
        String content = "";
        for (int i = 0; i < f.length; i++) {
            File imageFile = f[i];
            String fileName = imageFile.getName();
            content += "JPEGImages/"+fileName.replace("xml","jpg") + " Annotations/" + fileName;
            content += "\n";
        }
        System.out.println(f.length);
        System.out.println(content);
        writeTxtFile(inputPath.replace("xml/","train_list.txt"),content);
    }

    /**
     * 写文件
     *
     * @param newStr
     *            新内容
     * @throws IOException
     */
    public static boolean writeTxtFile(String filePath,String newStr) throws IOException {
        // 先读取原有文件内容，然后进行写入操作
        boolean flag = false;
        String filein = newStr + "\r\n";
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(filePath);
            // 将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该文件原有的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
                // System.getProperty("line.separator")
                // 行与行之间的分隔符 相当于“\n”
                buf = buf.append(System.getProperty("line.separator"));
            }
            buf.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            flag = true;
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            throw e1;
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return flag;
    }
}

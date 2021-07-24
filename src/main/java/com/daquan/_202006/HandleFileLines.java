package com.daquan._202006;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/1/3
 */
public class HandleFileLines {

    static String inputPath = "/Users/zhangdaquan/home/buaa/baiduyun/机器学习基础（AI）期末大作业/Fires_压缩/train/annotations";

    public static void main(String[] args) {
        //读取输入文件夹
        //遍历每个图片文件获取文件名，大小 以及对应的xml
        File inputFd = new File(inputPath);
        File[] f = inputFd.listFiles();
        for (int i = 0; i < f.length; i++) {
            File imageFile = f[i];
            String fileName = imageFile.getName();
            //截取前
            String txtContent = readFileContent(inputPath + "/" + fileName);
            System.out.println(createObject(txtContent));
            System.out.println("-----------"+fileName+"-----------");
        }
    }
    public static String createObject(String content){
        String[] s = content.split(";");
        String objects = "";
        for (int i = 0; i < s.length; i++) {
            String [] ss = s[i].split(" ");
            objects += "        <object>\n" +
                    "                <name>非金属打火机</name>\n" +
                    "                <pose>Unspecified</pose>\n" +
                    "                <truncated>0</truncated>\n" +
                    "                <difficult>0</difficult>\n" +
                    "                <bndbox>\n" +
                    "                        <xmin>"+ss[2]+"</xmin>\n" +
                    "                        <ymin>"+ss[3]+"</ymin>\n" +
                    "                        <xmax>"+ss[4]+"</xmax>\n" +
                    "                        <ymax>"+ss[5]+"</ymax>\n" +
                    "                </bndbox>\n" +
                    "        </object>\n";
        }

        return objects;
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
                sbf.append(";");
            }
            String str = sbf.toString();
            str = str.substring(0,str.length()-1);
            reader.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}

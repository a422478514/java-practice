package com.daquan._202006;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/1/3
 */
public class HandleImageFile {

    static String inputPath = "/Users/zhangdaquan/home/buaa/baiduyun/机器学习基础（AI）期末大作业/Fires_压缩/train/";
    static String outputPath = "/Users/zhangdaquan/home/buaa/baiduyun/机器学习基础（AI）期末大作业/Fires_压缩/train/xml";

    public static int [] readImage(File f) throws IOException {
        BufferedImage sourceImg = ImageIO.read(new FileInputStream(f));
        int arr[] = new int[2];
        System.out.println(sourceImg.getWidth()); // 源图宽度
        arr[0] = sourceImg.getWidth();
        System.out.println(sourceImg.getHeight()); // 源图高度
        arr[1] = sourceImg.getHeight();
        return arr;
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

    public static void main(String[] args) throws IOException {
        String annontations = "annotations";
        String images = "images";

        //读取输入文件夹
        //遍历每个图片文件获取文件名，大小 以及对应的xml
        File inputFd = new File(inputPath+images);
        File[] f = inputFd.listFiles();
        for (int i = 0; i < f.length; i++) {
            File imageFile = f[i];
            int[] size = readImage(imageFile);
            String fileName = imageFile.getName();
            //截取前
            String txtContent = readFileContent(inputPath + annontations + "/" + fileName.replace("jpg","txt"));

            String content = "<annotation>\n" +
                    "        <folder>JPEGImages</folder>\n" +
                    "        <filename>"+ fileName +"</filename>\n" +
                    "        <source>\n" +
                    "                <database>Unknown</database>\n" +
                    "        </source>\n" +
                    "        <size>\n" +
                    "                <width>"+size[0]+"</width>\n" +
                    "                <height>"+size[1]+"</height>\n" +
                    "                <depth>3</depth>\n" +
                    "        </size>\n" +
                    "        <segmented>0</segmented>\n" +
                    createObject(txtContent)+
                    "</annotation>";

            System.out.println(content);
            System.out.println("----------------------");
            String xmlPath = imageFile.getParent().replace("images","xml/")+fileName.replace("jpg","xml");
            creatTxtFile(xmlPath);
            writeTxtFile(xmlPath,content);
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

    /**
     * 创建文件
     *
     * @throws IOException
     */
    public static boolean creatTxtFile(String fileName) throws IOException {
        boolean flag = false;
        File filename = new File(fileName);
        if (!filename.exists()) {
            filename.createNewFile();
            flag = true;
        }
        return flag;
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

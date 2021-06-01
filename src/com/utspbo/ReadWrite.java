package com.utspbo;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {
    public void writeNum(ArrayList<String> dataNumber) {
        File writerNum = new File("output.txt");
        try{
            FileWriter fw = new FileWriter(writerNum,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(dataNumber));
            bw.flush();
            bw.newLine();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeStr(ArrayList<String> dataString) {
        File writerStr = new File("output1.txt");
        try {
            FileWriter fw = new FileWriter(writerStr,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(dataString));
            bw.flush();
            bw.newLine();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readNum() {
        File file = new File("output.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String barisData;
            System.out.println("Array inNumber");
            while ((barisData = br.readLine())!=null){
                System.out.println(barisData);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("file tidak dapat dibaca");
        }

    }

    public void readStr() {
        File file = new File("output1.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String barisData;
            System.out.println("Array inString");
            while ((barisData = br.readLine())!=null){
                System.out.println(barisData);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("file tidak dapat dibaca");
        }

    }

}

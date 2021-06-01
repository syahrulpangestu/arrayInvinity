package com.utspbo;

import java.io.*;
import java.util.ArrayList;

/**
 * Class ReadWrite untuk menyimpan data arraylist yang akan ditampilkan, maupun sudah disimpan
 */
public class ReadWrite {
    /**
     * Method WriteNum untuk menyimpan dataNumber kedalam notepad output.txt
     * @param dataNumber menampun data arrayList inNumber
     */
    public void writeNum(ArrayList<String> dataNumber) {
        File writerNum = new File("output.txt");
        try{
            FileWriter fw = new FileWriter(writerNum,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(dataNumber));
            bw.flush();
            bw.newLine();
            bw.close();
            /**
             * @exception IOException untuk menampilkan pesan exception tentang file
             */
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method WriteStr untuk menyimpan dataString kedalam notepad output.txt
     * @param dataString menampun data arrayList inNumber
     */
    public void writeStr(ArrayList<String> dataString) {
        File writerStr = new File("output1.txt");
        try {
            FileWriter fw = new FileWriter(writerStr,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(dataString));
            bw.flush();
            bw.newLine();
            bw.close();
            /**
             * @exception IOException untuk menampilkan pesan exception tentang file
             */
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method ReadNum untuk menampilkan angka dari dalam file output.txt
     */
    public void readNum() {
        File file = new File("output.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String barisData;
            System.out.println("Array inNumber");
            while ((barisData = br.readLine())!=null){
                System.out.println(barisData);
            }
            /**
             * @exception FileNotFoundException untuk menampilkan pesan exception jka file tidak ditemukan
             */
        }catch (FileNotFoundException e){
            e.printStackTrace();
            /**
             * @exception Exception menampilkan pesan bahwa file tidak dapat dibaca
             */
        }catch (Exception e){
            System.out.println("file tidak dapat dibaca");
        }

    }

    /**
     * Method ReadNum untuk menampilkan angka dari dalam file output.txt
     */
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
            /**
             * @exception Exception menampilkan pesan bahwa file tidak dapat dibaca
             */
        }catch (Exception e){
            /**
             * @exception Exception untuk menampilkan pesan exception jka file tidak ditemukan
             */
            System.out.println("file tidak dapat dibaca");
        }

    }

}

package com.utspbo;

import java.io.*;
import java.util.ArrayList;

/**
 * JavaDoc merupakan program untuk menginputkan angka atau huruf
 * secara acak yang nantinya akan dipisah dan dimasukan ke dalam
 * inSring atau inNumber untuk dikirimkan ke Class ReadWrite untuk
 * disimpan kedalam notepad dan kemudian ditampilkan.
 *
 * @author Syahrul Pangestu
 * @version 1.0
 * @since 2021-06-1
 */

/**
 * Main Class tempat program JavaDoc dijalankan
 */
public class Main {

    /**
     * method main untuk mengeksekusi program yang dibuat
     * @param args untuk mengenali main yag digunakan mengekseekusi program
     */
    public static void main(String[] args) {
        /**
         * attribut inString berupa array dengan size 100 untuk menampung String
         * attribut inNumber berupa array dengan size 100 untuk menampung Number
         */
        String[] inString = new String[100];
        String[] inNumber = new String[100];

        /**
         * objek arrNumber dari Class ArrayList untuk merapikan bentuk array dari inNumber
         * objek arrString dari Class ArrayList untuk merapikan bentuk array dari inString
         */
        ArrayList<String> arrNumber = new ArrayList<>();
        ArrayList<String> arrString = new ArrayList<>();

        /**
         * mendeklarasikan attribut array inputUser bertipe data String untuk menamping semua inputan
         */
        String[] inputUser = new String[100];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("masukan inputan");
        try {
            /**
             * perulangan infinity agar dapat input data sesuai keinginan user
             */
            for (int i = 0; true; i++) {
                System.out.print("index ke-" + i + " ");
                /**
                 * inputan yang akan digunakan user untuk memasukan data
                 */
                inputUser[i] = bufferedReader.readLine();
                try {
                    /**
                     * kondisi untuk mengecek apakah attribut inputuUer kosong
                     */
                    if (!inputUser[i].isEmpty()){
                        /**
                         * kondisi untuk mengecek apakah inputUser mengandung angka
                         * jika tidak, maka akan dicek kembali apakah mengandung alphabet
                         * input stop tidak akan masuk kedalam notepad
                         */
                        if (inputUser[i].matches("[0-9.-]+")) {
                            inNumber[i] = inputUser[i];
                            arrNumber.add(inNumber[i]);
                        } else if (inputUser[i].matches("[a-zA-Z]*") && !inputUser[i].equals("stop") && !inputUser[i].equals("STOP")) {
                            inString[i] = inputUser[i];
                            arrString.add(inString[i]);
                        }
                    }else {
                        /**
                         * @throws jika nilai dari attribut inputUser bernilai kosong atau null
                         */
                        throw new Exception("null");
                    }
                    /**
                     * @exception untuk jika input melebihi index dan semacamnya
                     */
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    /**
                     * kondisi untuk menghentikan program dengan menulis stop uppercase atau lowercase
                     * jika iya maka akan menaampilkan dan menyimpan data dari databse
                     * @throw melemparexception ketika program dihentikan
                     */
                    if ("stop".equals(inputUser[i]) || "STOP".equals(inputUser[i])) {
                        ReadWrite readWrite = new ReadWrite();
                        readWrite.writeNum(arrNumber);
                        readWrite.writeStr(arrString);
                        readWrite.readNum();
                        readWrite.readStr();
                        throw new Exception("Program has been stoped");
                    }
                    /**
                     * @exception Exception untuk menangkap throw yan dikirimkan
                     */
                }catch (Exception exception) {
                    exception.printStackTrace();
                    System.exit(0);
                }
            }
            /**
             * @exception IOException untuk menangkap semua error yang ada dalam program
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

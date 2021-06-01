package com.utspbo;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] inString = new String[100];
        String[] inNumber = new String[100];

        ArrayList<String> arrNumber = new ArrayList<>();
        ArrayList<String> arrString = new ArrayList<>();

        String[] inputUser = new String[100];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("masukan inputan");
        try {
            for (int i = 0; true; i++) {
                System.out.print("index ke-" + i + " ");
                inputUser[i] = bufferedReader.readLine();
                try {
                    if (!inputUser[i].isEmpty()){
                        if (inputUser[i].matches("[0-9.-]+")) {
                            inNumber[i] = inputUser[i];
                            arrNumber.add(inNumber[i]);
                        } else if (inputUser[i].matches("[a-zA-Z]*") && !inputUser[i].equals("stop") && !inputUser[i].equals("STOP")) {
                            inString[i] = inputUser[i];
                            arrString.add(inString[i]);
                        }
                    }else {
                        throw new Exception("null");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if ("stop".equals(inputUser[i]) || "STOP".equals(inputUser[i])) {
                        ReadWrite readWrite = new ReadWrite();
                        readWrite.writeNum(arrNumber);
                        readWrite.writeStr(arrString);
                        readWrite.readNum();
                        readWrite.readStr();
                        throw new Exception("Program has been stoped");
                    }
                }catch (Exception exception) {
                    exception.printStackTrace();
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

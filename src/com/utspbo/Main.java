package com.utspbo;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> inNumber = new ArrayList<>();
        ArrayList<String> inString = new ArrayList<>();

        String inputUser;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("masukan inputan");
        try {
            for (int i = 0; true; i++) {
                System.out.print("index ke-" + i + " ");
                inputUser = bufferedReader.readLine();
                try {
                    if (!inputUser.isEmpty()){
                        if (inputUser.matches("[0-9.-]+")) {
                            inNumber.add(inputUser);
                        } else if (inputUser.matches("[a-zA-Z]*") && !inputUser.equals("stop") && !inputUser.equals("STOP")) {
                            inString.add(inputUser);
                        }
                    }else {
                        throw new Exception("null");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if ("stop".equals(inputUser) || "STOP".equals(inputUser)) {
                        ReadWrite readWrite = new ReadWrite();
                        readWrite.writeNum(inNumber);
                        readWrite.writeStr(inString);
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

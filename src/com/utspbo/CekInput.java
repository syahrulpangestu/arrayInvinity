package com.utspbo;

import java.util.ArrayList;

public class CekInput {
    public void differ(String[] inputUser) throws Exception {
        String[] inString = new String[5];
        String[] inNumber = new String[5];
        int k = 0;
        int j = 0;

        try {
            for (int i = 0; i < inputUser.length; i++) {
                if (inputUser[i] != null && !inputUser[i].isEmpty()) {
                    if (inputUser[i].matches("^\\d+(\\.\\d+)?")){
                        inNumber[j] = inputUser[i];
                        j++;
                    }else {
                        inString[k] = inputUser[i];
                        k++;
                    }
                } else {
                    throw new Exception("null");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<String> dataString = new ArrayList<>();
        ArrayList<String> dataNumber = new ArrayList<>();

        try {
            for (int i = 0; i < inNumber.length; i++) {
                if (inNumber[i] != null) {
                    dataNumber.add(inNumber[i]);
                }
            }
            for (int i = 0; i < inString.length; i++) {
                if (inString[i] != null) {
                    dataString.add(inString[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ReadWrite readWrite = new ReadWrite();
        readWrite.writeNum(dataNumber);
        readWrite.writeStr(dataString);
        readWrite.readNum();
        readWrite.readStr();
        showInput(inputUser);
    }

    private void showInput(String[] inputUser) {
        System.out.print("array inputan : ");
        for (int i = 0; i < inputUser.length; i++) {
            if (inputUser[i] != null) {
                System.out.print(inputUser[i] + " ");
            }
        }
    }

}

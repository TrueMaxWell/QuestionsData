package com.company.Data;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\xaxax\\IdeaProjects\\Questions\\src\\com\\company\\Data\\data.csv";
        rewriteFile(path, 500);                   //Roma, Zlata, Vlad
        rewriteFile2(path, 300);                  //Zlata, Vlad


    }

    public static void rewriteFile(String stringPath, int max) {
        String result = checkResult(stringPath, max);
        Path in = Paths.get(stringPath);
        Path out = Paths.get(in.getParent().toString() + "\\2" + in.getFileName().toString());

        try {
            Files.write(out, Collections.singleton(result), StandardCharsets.UTF_8);
            System.out.println("File at : " + in.getParent().toString() + "\\2" + in.getFileName().toString() + "\nContains :\n" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void rewriteFile2(String stringPath, int max) {
        String result = checkResult(stringPath, max);
        try {
            FileOutputStream out = new FileOutputStream(stringPath.substring(0, stringPath.lastIndexOf(".")) + "2" + stringPath.substring(stringPath.lastIndexOf(".")));
            out.write(result.getBytes(StandardCharsets.UTF_8));
            System.out.println("File at : " + stringPath.substring(0, stringPath.lastIndexOf(".")) + "2" + stringPath.substring(stringPath.lastIndexOf(".")) + "\nContains :\n" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String checkResult(String path, int max) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new FileInputStream(path));
            String[] test;
            boolean check;

            while (scanner.hasNextLine()) {
                test = scanner.nextLine().split("\\|");
                check = true;
                for (String str : test) {
                    try {
                        if (Integer.parseInt(str) >= max) {
                            check = false;
                        }
                    } catch (Exception ignored) {

                    }
                }
                if (check) {
                    stringBuilder.append(Arrays.toString(test)).append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Incorrect path");
        }

        return stringBuilder.toString().replaceAll("[]\\[,]", "");
    }
}

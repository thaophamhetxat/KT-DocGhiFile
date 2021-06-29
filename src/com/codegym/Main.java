package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Nguoi> list = new ArrayList<>();
    static File nguoi = new File("nguoi.txt");

    public static void main(String[] args) throws IOException {
        nguoi.createNewFile();
        docFile();
        for (Nguoi n : list) {
            System.out.println(n);
        }
        list.add(new Nguoi("Thao", 18, "nam", "0988788"));
        ghiFile();
    }

    public static void docFile() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(nguoi);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(", ");
                if (str.length >= 4) {
                    list.add(new Nguoi(str[0], Integer.parseInt(str[1].trim()), str[2], str[3]));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }

    public static void ghiFile() throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(nguoi);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Nguoi n : list) {
                bufferedWriter.write(n.ghi());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }

    }


}

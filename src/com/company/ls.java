package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.*;

public class ls {

    private File file;

    public ls(String dir_or_file) {
        file = new File(dir_or_file);
    }

    public String printFile(File file, Boolean flag_l, Boolean flag_h, Boolean flag_r, String OutputFileName) {
        String str = "";
        String nameS = file.getName();

        if (!flag_l && !flag_h) System.out.println(nameS);
        else {
            Date d = new Date(file.lastModified());
            SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String dateS = dt.format(d);

            Long lengthL = file.length();
            String lengthS = lengthL.toString();
            if (flag_h) {
                if (lengthL > 1024 * 1024 * 1024) {
                    lengthL = lengthL / (1024 * 1024 * 1024);
                    lengthS = lengthL.toString() + "Gb";
                } else if (lengthL > 1024 * 1024) {
                    lengthL = lengthL / (1024 * 1024);
                    lengthS = lengthL.toString() + "Mb";
                } else if (lengthL > 1024) {
                    lengthL = lengthL / 1024;
                    lengthS = lengthL.toString() + "Kb";
                }
            }
            String rwxS = "";
            if (!flag_h) {
                if (file.canRead()) rwxS = rwxS + "1";
                else rwxS = rwxS + "0";

                if (file.canWrite()) rwxS = rwxS + "1";
                else rwxS = rwxS + "0";

                if (file.canExecute()) rwxS = rwxS + "1";
                else rwxS = rwxS + "0";
            } else {

                if (file.canRead()) rwxS = rwxS + "r";

                if (file.canWrite()) rwxS = rwxS + "w";

                if (file.canExecute()) rwxS = rwxS + "x";
            }
            if (flag_r) str = String.format("%5s %10s %25s %5s", rwxS, lengthS, dateS, nameS);
            else str = String.format("%30s %25s %10s %5s", nameS, dateS, lengthS, rwxS);

        }
        return str;
    }


    public void printDir(Boolean flag_l, Boolean flag_h, Boolean flag_r, String OutputFileName) {
        if (flag_l == null) flag_l = false;
        if (flag_h == null) flag_h = false;
        if (flag_r == null) flag_r = false;
        if (OutputFileName == null) OutputFileName = "";
        if (file.exists()) {
            if (OutputFileName == "") {
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    for (int i = 0; i < files.length; i++)
                        System.out.println(this.printFile(files[i], flag_l, flag_h, flag_r, OutputFileName));
                } else
                    System.out.println(this.printFile(file, flag_l, flag_h, flag_r, OutputFileName));

            } else {
                try (FileWriter writer = new FileWriter(OutputFileName)) {
                    if (file.isDirectory()) {
                        File[] files = file.listFiles();
                        for (int i = 0; i < files.length; i++)
                            writer.write(this.printFile(files[i], flag_l, flag_h, flag_r, OutputFileName) + "\r\n");
                    } else
                        writer.write(this.printFile(file, flag_l, flag_h, flag_r, OutputFileName) + "\r\n");
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
            }

        }
        else System.out.println("File not exist!");
    }
}


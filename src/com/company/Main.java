package com.company;

import java.io.*;
/*
 Вывод содержимого указанной в качестве аргумента директории в виде отсортированного списка имен файлов.
 1) Флаг -l (long) переключает вывод в длинный формат, в котором, кроме имени файла, указываются права
    на выполнение/чтение/запись в виде битовой маски ХХХ, время последней модифиации и размер в байтах.
 2) Флаг -h (human-readable) переключает вывод в человеко-читаемый формат(размер в кило-, мега- или гигабайтах,
    права на выполнение в виде rwx).
 3) Флаг -r (reverse) меняет порядок вывода на противоположный.
 4) Флаг -o (output) указывает имя файла, в который следует вывести результат, если этот флаг отсутствует, результат
 выводится в консоль.
 В случае, если в качестве аргумента указан файл, а не директория, следует вывести информацию об этом файле.
 Command Line: ls[-l][-h][-r][-o output.file] directory_or_file
 ? reverse ЭТО ЧО
 ? Is ЭТО ЧО
 ? как обработать -- в параметрах
 ? чтлбы не было одновременно -l и -h
*/

public class Main {
    public static void main(String[] args) {
        Boolean flag_l = false;
        Boolean flag_h = false;
        Boolean flag_r = false;
        Boolean flag_o = false;
        String outputfile = "";
        String directory_or_file = "";
        String allargs = "";

        for (int i = 0; i < args.length - 1; i++) {
            allargs += args[i];
        }
        if (allargs.indexOf('-') != 0) {
            System.out.println("There are notavable arguments");
            return;
        }
        allargs = allargs.substring(1);
        directory_or_file = args[args.length - 1];
        String[] arrargs = allargs.split("-");

        for (int i = 0; i < arrargs.length; i++) {
            switch (arrargs[i].substring(0,1)) {
                case "l":
                    flag_l = true;
                    break;
                case "h":
                    flag_h = true;
                    break;
                case "r":
                    flag_r = true;
                    break;
                case "o":
                    flag_o = true;
                    outputfile = arrargs[i].substring(1);
                    break;
                default:
                    System.out.println("There are notavable arguments");
                    break;
            }
        }
        String list[] = new File(directory_or_file).list();
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);

    }
}

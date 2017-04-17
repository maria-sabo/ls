
package com.company;

import java.io.*;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Launcher {

    @Option(name = "-l", metaVar = "flag_l", usage = "Long output")
    private Boolean flag_l;

    @Option(name = "-h", metaVar = "flag_h", usage = "Human output")
    private Boolean flag_h;

    @Option(name = "-r", metaVar = "flag_r", usage = "Reverse output")
    private Boolean flag_r;

    @Option(name = "-o", metaVar = "Output", usage = "Output")
    private String OutputFileName;

    @Argument(required = true, metaVar = "InputDir_or_File", usage = "Input dir_or_file name")
    private String Input_Dir_or_File;


    public static void main(String[] args) {
        new Launcher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar ls.jar [-l] [-h] [-r] [-o OutputFileName] Input_Dir_or_File");
            parser.printUsage(System.err);
            return;
        }
      //  System.out.println(flag_l);
       // System.out.println(flag_h);
       // System.out.println(flag_r);
       // System.out.println(OutputFileName);
       // System.out.println(Input_Dir_or_File);
    }
}
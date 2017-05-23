import java.io.*;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.util.ArrayList;

public class Launcher {

    @Option(name = "-l", metaVar = "flag_l", usage = "Long output")
    private boolean flag_l;

    @Option(name = "-h", metaVar = "flag_h", usage = "Human output")
    private boolean flag_h;

    @Option(name = "-r", metaVar = "flag_r", usage = "Reverse output")
    private boolean flag_r;

    @Option(name = "-o", metaVar = "Output", usage = "Output")
    private String OutputFileName;

    @Argument(required = true, metaVar = "InputDir_or_File", usage = "Input dir_or_file name")
    private String Input_Dir_or_File;


    public static void main(String[] args) {
        new Launcher().launch(args);
    }

    String launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        String str = "";
        try {
            parser.parseArgument(args);

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar ls.jar [-l] [-h] [-r] [-o OutputFileName] Input_Dir_or_File");
            parser.printUsage(System.err);
            //return str;
        }
        try {
            ArrayList<String> dirlist;
            dirlist = new Ls(Input_Dir_or_File).printDir(flag_l, flag_h, flag_r);

            PrintStream printStream;
            if (OutputFileName == null) printStream = System.out;
            else {
                FileOutputStream fos = new FileOutputStream(OutputFileName);
                printStream = new PrintStream(fos);
            }
            for (int i = 0; i < dirlist.size(); i++)
                printStream.println(dirlist.get(i) + "\n");
            str = OutputFileName;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
        // }
    }
}

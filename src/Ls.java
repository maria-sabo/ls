import javax.management.ObjectName;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.*;

public class Ls {

    private File[] files;
    private ArrayList<String> dirlist;


    public Ls(String dir_or_file) {
        File file = new File(dir_or_file);
        dirlist = new ArrayList<String>();

        if (file.isDirectory())
            files = file.listFiles();
        else {
            files = new File[1];
            files[0] = file;
        }

        Arrays.sort(files, new Comparator<File>() {
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public ArrayList<String> printDir(boolean flag_l, boolean flag_h, boolean flag_r) throws IOException {

        int from = 0;
        int incr = 1;
        if (flag_r) {
            from = files.length-1;
            incr = -1;
        }
        for (int i = from; 0 <= i && i <= files.length-1; i += incr) dirlist.add(printFile(files[i], flag_l, flag_h, flag_r));
        return dirlist;
    }

    public String printFile(File file, boolean flag_l, boolean flag_h, boolean flag_r) {
        String str = "";
        String nameS = file.getName();

        if (!flag_l && !flag_h) str = nameS;
        else {
            Date d = new Date(file.lastModified());
            SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String dateS = dt.format(d);

            Long lengthL = file.length();
            String lengthS = lengthL.toString();
            if (flag_h) {
                lengthS = lengthS + "b";
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

            if (flag_r) str = String.format("%5s %10s %25s %s", rwxS, lengthS, dateS, nameS);
            else str = String.format("%40s %25s %10s %5s", nameS, dateS, lengthS, rwxS);

        }
        return str;
    }
}






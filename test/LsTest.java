import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LsTest {
    @Test
    public void printD1() {
        ArrayList<String> dirlist;
        boolean f_l = true;
        boolean f_h = true;
        boolean f_r = true;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/test1.txt").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[  rwx         7b       13.05.2017 00:05:40 test1.txt]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void printD2() {
        ArrayList<String> dirlist;
        boolean f_l = true;
        boolean f_h = true;
        boolean f_r = false;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/test1.txt").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[                               test1.txt       13.05.2017 00:05:40         7b   rwx]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void printD3() {
        ArrayList<String> dirlist;
        boolean f_l = true;
        boolean f_h = true;
        boolean f_r = false;
        String outputfile;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/test1.txt").printDir(f_l, f_h, f_r);

            assertEquals(dirlist.toString(), "[                               test1.txt       13.05.2017 00:05:40         7b   rwx]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


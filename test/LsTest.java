import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LsTest {
    @Test
    public void printD() {
        ArrayList<String> dirlist;
        boolean f_l = true;
        boolean f_h = true;
        boolean f_r = true;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/o.txt").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[              0b       01.01.1970 03:00:00 o.txt]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void printD0() {
        ArrayList<String> dirlist;
        boolean f_l = true;
        boolean f_h = true;
        boolean f_r = true;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/empty.txt").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[  rwx         0b       30.05.2017 13:10:34 empty.txt]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
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
        boolean f_h = false;
        boolean f_r = false;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/test1.txt").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[                               test1.txt       13.05.2017 00:05:40          7   111]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void printD4() {
        ArrayList<String> dirlist;
        boolean f_l = true;
        boolean f_h = false;
        boolean f_r = true;
        String outputfile;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/test1.txt").printDir(f_l, f_h, f_r);

            assertEquals(dirlist.toString(), "[  111          7       13.05.2017 00:05:40 test1.txt]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void printD5() {
        ArrayList<String> dirlist;
        boolean f_l = false;
        boolean f_h = false;
        boolean f_r = false;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/test1.txt").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[test1.txt]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void printD6() {
        ArrayList<String> dirlist;
        boolean f_l = false;
        boolean f_h = false;
        boolean f_r = false;
        try {
            dirlist = new Ls("C:/Users/808625/IdeaProjects/ls/test/emp").printDir(f_l, f_h, f_r);
            assertEquals(dirlist.toString(), "[]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


package me.c1tad31.chb.utils;

import java.io.File;

public class FileSender {
    public static File sendFile(String string) {
        return new File("CodeHouseBot\\src\\main\\java\\me\\c1tad31\\chb\\codingcommands\\" + string);
    }
}

package com.grid.connected.shapes.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads the file provides and loads up the information in the file to a grid.
 */
public class GridReader {
    public static List<char[]> readGrid(String fileName) {
        List<char[]> chars;
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            chars = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                chars.add(line.toCharArray());
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Error reading grid file " + fileName);
            throw new RuntimeException(e);
        }

        return chars;
    }

}

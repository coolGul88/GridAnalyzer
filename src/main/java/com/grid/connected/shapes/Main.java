package com.grid.connected.shapes;

import com.grid.connected.shapes.analyzer.GridAnalyzer;
import java.util.List;

import static com.grid.connected.shapes.reader.GridReader.readGrid;

public class Main {
    private static final String DATA_LARGE = "src/main/resources/data_large.txt";
    private static final String DATA_SMALL = "src/main/resources/data_small.txt";

    public static void main(String[] args) {
        String fileName = DATA_LARGE;

        List<char[]> grid = readGrid(fileName);
        GridAnalyzer gridAnalyzer = new GridAnalyzer(grid);
        //clean up file name
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);

        System.out.println("\n\nNumber of connected shapes for file:  " +  fileName + " is : "
                + gridAnalyzer.getConnectedShapes()+ "\n\n");
    }
}

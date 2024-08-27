package com.grid.connected.shapes.analyzer;

import java.util.List;

/**
 * GridAnalyzer is use to analyze the grid for connected shapes.
 * It performs a DFS in the four directions - UP, DOWN, LEFT and RIGHT.
 * After performing the traversal it gives the number of connected shapes.
 */
public class GridAnalyzer {
    private final List<char[]> grid;
    private final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m, n;

    public GridAnalyzer(List<char[]> grid) {
        this.grid = grid;
    }

    public int getConnectedShapes() {
        if (grid == null || grid.isEmpty())
            return 0;

        m = grid.size();
        n = grid.get(0).length;
        int shapes = 0;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.grid.get(i)[j] == '1') {
                    this.grid.get(i)[j] = '0';
                    gridTraversal(i, j, grid);
                    shapes++;
                }
            }
        }

        return shapes;
    }

    private void gridTraversal(int i, int j, List<char[]> grid) {
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (isValid(x, y) && grid.get(x)[y] == '1') {
                grid.get(x)[y] = '0';
                gridTraversal(x, y, grid);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < this.m && y < this.n;
    }

}

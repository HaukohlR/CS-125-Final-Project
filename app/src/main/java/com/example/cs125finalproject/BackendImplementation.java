package com.example.cs125finalproject;

public class BackendImplementation implements BackendStuff {
    @Override
    public int[][] generateGrid(int level) {
        int lvlValue = 20 + level;
        if (lvlValue > 50) {
            lvlValue = 50;
        }
        int[][] grid = new int[5][5];
        for (int k = 0; k < grid.length; k++) {
            for (int i = 0; i < grid[k].length; i++) {
                int value = (int)(Math.random() * 100);
                if (value < lvlValue) {
                    grid[i][k] = 0;
                } else if (value < 100 - lvlValue) {
                    grid[i][k] = 1;
                } else {
                    int point = (int) (Math.random() * 2) + 2;
                    grid[i][k] = point;
                }
            }
        }
        return grid;
    }
    @Override
    public int[] calculateBombsColumns(int[][] grid) {
        int[] colSum = new int[5];
        for (int k = 0; k < grid[0].length; k++) {
            colSum[k] = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][k] == 0) {
                    colSum[k]++;
                }
            }
        }
        return colSum;
    }
    @Override
    public int[] calculateBombsRows(int[][] grid) {
        int[] rowSum = new int[5];
        for (int k = 0; k < grid.length; k++) {
            rowSum[k] = 0;
            for (int i = 0; i < grid[k].length; i++) {
                if (grid[k][i] == 0) {
                    rowSum[k]++;
                }
            }
        }
        return rowSum;
    }
    @Override
    public int[] calculatePointsColumns(int[][] grid) {
        int[] colSum = new int[5];
        for (int k = 0; k < grid[0].length; k++) {
            colSum[k] = 0;
            for (int i = 0; i < grid.length; i++) {
                colSum[k] += grid[i][k];
            }
        }
        return colSum;
    }
    @Override
    public int[] calculatePointsRows(int[][] grid) {
        int[] rowSum = new int[5];
        for (int k = 0; k < grid.length; k++) {
            rowSum[k] = 0;
            for (int i = 0; i < grid[k].length; i++) {
                rowSum[k] += grid[k][i];
            }
        }
        return rowSum;
    }
}

package com.example.cs125finalproject;

public class BackendImplementation implements BackendStuff {
    int totalPoints;
    int roundPoints;
    @Override
    public int[][] generateGrid(int level) {
        int[][] grid = new int[5][5];
        for (int k = 0; k < grid.length; k++) {
            for (int i = 0; i < grid[k].length; i++) {
                int value = (int)(Math.random() * 3);
                grid[i][k] = value;
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

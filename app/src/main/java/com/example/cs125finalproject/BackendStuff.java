package com.example.cs125finalproject;

public interface BackendStuff {
    //makes the grid
    int[][] generateGrid(int level);
    int[] calculatePointsColumns(int[][] grid);
    int[] calculatePointsRows(int[][] grid);
    int[] calculateBombsColumns(int[][] grid);
    int[] calculateBombsRows(int[][] grid);
}

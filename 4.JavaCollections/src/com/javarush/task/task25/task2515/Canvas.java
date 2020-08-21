package com.javarush.task.task25.task2515;

public class Canvas {
    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c) {
        int iX = (int) Math.round(x), iY = (int) Math.round(y);
        if (iX >= 0 && iX < matrix[0].length && iY >= 0 && iY < matrix.length) {
            matrix[iY][iX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int iX = (int) Math.round(x), iY = (int) Math.round(y);
        for (int i = 0; i <= iY; i++) {
            for (int j = 0; j <= iX; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(iX + j, iY + i, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}

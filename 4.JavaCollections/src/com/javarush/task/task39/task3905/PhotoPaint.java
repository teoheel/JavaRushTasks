package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length) {
            return false;
        }
        if (desiredColor == image[y][x]) {
            return false;
        }

        Color currentColor = image[y][x];

        paintFill(image, x, y, desiredColor, currentColor);

        return true;
    }

    private void paintFill(Color[][] image, int x, int y, Color desiredColor, Color currentColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length || image[y][x] != currentColor) {
            return;
        } else {
            image[y][x] = desiredColor;
        }

        paintFill(image, x, y + 1, desiredColor, currentColor);
        paintFill(image, x, y - 1, desiredColor, currentColor);
        paintFill(image, x + 1, y, desiredColor, currentColor);
        paintFill(image, x - 1, y, desiredColor, currentColor);
    }
}

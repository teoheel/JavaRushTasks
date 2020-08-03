package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    private Color getColorByValue(int value) {
        Color color = Color.NONE;
        if (value == 0) {
            color = Color.WHITE;
        } else if (value == 2) {
            color = Color.VIOLET;
        } else if (value == 4) {
            color = Color.PURPLE;
        } else if (value == 8) {
            color = Color.BLUE;
        } else if (value == 16) {
            color = Color.LIGHTBLUE;
        } else if (value == 32) {
            color = Color.GREEN;
        } else if (value == 64) {
            color = Color.LIGHTGREEN;
        } else if (value == 128) {
            color = Color.ORANGE;
        } else if (value == 256) {
            color = Color.PINK;
        } else if (value == 512) {
            color = Color.ORANGERED;
        } else if (value == 1024) {
            color = Color.HOTPINK;
        } else if (value == 2048) {
            color = Color.DEEPPINK;
        }
        return color;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        if (value == 0) {
            setCellValueEx(x, y, getColorByValue(value), "");
        } else setCellValueEx(x, y, getColorByValue(value), Integer.toString(value));
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
        }
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[x][y] != 0);

        if (getRandomNumber(10) < 9) {
            gameField[x][y] = 2;
        } else gameField[x][y] = 4;
    }

    private void createGame() {
        score = 0;
        setScore(score);
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                gameField[x][y] = 0;
            }
        }
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private boolean compressRow(int[] row) {
        boolean isMoved = false;
        int temp;
        for (int x = 0; x < SIDE - 1; x++) {
            for (int y = x + 1; y < SIDE; y++) {
                if (row[x] == 0) {
                    if (row[y] != 0) {
                        temp = row[y];
                        row[y] = row[x];
                        row[x] = temp;
                        if (!isMoved) isMoved = true;
                    }
                }
            }
        }
        return isMoved;
    }

    private boolean mergeRow(int[] row) {
        boolean isMoved = false;
        for (int i = 0; i < SIDE - 1; i++) {
            if (row[i] == row[i + 1] && row[i] != 0) {
                row[i] = row[i] * 2;
                row[i + 1] = 0;
                if (!isMoved) isMoved = true;
                score += row[i];
                setScore(score);
            }
        }
        return isMoved;
    }

    private void rotateClockwise() {
        int[][] rotateMatrix = new int[SIDE][SIDE];
        for (int x = 0, i = 0; x < SIDE; x++, i++) {
            for (int y = 0, j = SIDE - 1; y < SIDE; y++, j--) {
                rotateMatrix[i][j] = gameField[y][x];

            }
        }
        gameField = rotateMatrix;
    }

    private void moveLeft() {
        boolean create = false;
        for (int x = 0; x < SIDE; x++) {
            if (compressRow(gameField[x])) create = true;
            if (mergeRow(gameField[x])) create = true;
            if (compressRow(gameField[x])) create = true;
        }
        if (create) createNewNumber();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private int getMaxTileValue() {
        int max = gameField[0][0];
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[x][y] > max) {
                    max = gameField[x][y];
                }
            }
        }
        return max;
    }

    private boolean canUserMove() {
        boolean canMove = false;
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[x][y] == 0) {
                    canMove = true;
                    break;
                }
            }
        }
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (x > 0 && y > 0) {
                    if (gameField[x][y] == gameField[x - 1][y] || gameField[x][y] == gameField[x][y - 1])
                        canMove = true;
                    break;
                } else if (x < SIDE - 1 && y < SIDE - 1) {
                    if (gameField[x][y] == gameField[x + 1][y] || gameField[x][y] == gameField[x][y + 1])
                        canMove = true;
                }
            }
        }
        return canMove;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game over", Color.BLACK, 12);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.BLACK, 12);
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            }
        } else {
            if (canUserMove()) {
                switch (key) {
                    case LEFT:
                        moveLeft();
                        drawScene();
                        break;
                    case UP:
                        moveUp();
                        drawScene();
                        break;
                    case RIGHT:
                        moveRight();
                        drawScene();
                        break;
                    case DOWN:
                        moveDown();
                        drawScene();
                        break;
                }
            } else gameOver();
        }
    }
}

package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int x;
    private int y;
    private int score = 0;
    private int countMinesOnField = 0;
    private int countClosedTiles = SIDE * SIDE;
    private int countFlags;
    private boolean isGameStarted = false;
    private boolean isGameStopped = false;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGameField();
    }

    private void createGameField() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
    }

    private void createGame() {
        isGameStarted = true;
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                boolean isMine = false;
                if (this.x != x && this.y != y) {
                    if (getRandomNumber(10) == 1) {
                        isMine = true;
                        countMinesOnField++;
                    }
                }
                gameField[y][x] = new GameObject(x, y, isMine);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private ArrayList<GameObject> getNeighbors(GameObject gameObject) {
        ArrayList<GameObject> list = new ArrayList<>();

        int top = Math.max(gameObject.y - 1, 0);
        int bottom = Math.min(gameObject.y + 1, SIDE - 1);
        int left = Math.max(gameObject.x - 1, 0);
        int right = Math.min(gameObject.x + 1, SIDE - 1);

        for (int y = top; y <= bottom; y++) {
            for (int x = left; x <= right; x++) {
                if (gameObject.x != x || gameObject.y != y) {
                    list.add(gameField[y][x]);
                }
            }
        }

        return list;
    }

    private void countMineNeighbors() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                if (!gameField[y][x].isMine) {
                    ArrayList<GameObject> neighbors = getNeighbors(gameField[y][x]);
                    for (GameObject neighbor : neighbors) {
                        if (neighbor.isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (isGameStopped || gameObject.isFlag || gameObject.isOpen) return;
        else {
            gameObject.isOpen = true;
            countClosedTiles--;
            setCellColor(x, y, Color.GREEN);
            if (gameObject.isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else {
                score += 5;
                if (gameObject.countMineNeighbors == 0) {
                    setCellValue(x, y, "");
                    ArrayList<GameObject> neighbors = getNeighbors(gameObject);
                    for (GameObject neighbor : neighbors) {
                        if (!neighbor.isOpen) {
                            openTile(neighbor.x, neighbor.y);
                        }
                    }
                } else {
                    setCellNumber(x, y, gameObject.countMineNeighbors);
                }
                setScore(score);
                if (countMinesOnField == countClosedTiles) {
                    win();
                }
            }
        }
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (!isGameStopped) {
            if (!gameObject.isOpen) {
                if (!gameObject.isFlag) {
                    if (countFlags != 0) {
                        gameObject.isFlag = true;
                        countFlags--;
                        setCellValue(x, y, FLAG);
                        setCellColor(x, y, Color.YELLOW);
                    }
                } else {
                    gameObject.isFlag = false;
                    countFlags++;
                    setCellValue(x, y, "");
                    setCellColor(x, y, Color.ORANGE);
                }
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game over", Color.BLACK, 12);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.BLACK, 12);
    }

    private void restart() {
        isGameStopped = false;
        isGameStarted = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(0);
        createGameField();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            if (!isGameStarted) {
                this.x = x;
                this.y = y;
                createGame();
            }
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}
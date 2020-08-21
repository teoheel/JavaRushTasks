package com.javarush.task.task35.task3513;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private static final int FIELD_WIDTH = 4;
    int score = 0, maxTile = 0;
    private boolean isSaveNeeded = true;
    private Stack<Integer> previousScores = new Stack<>();
    private Stack<Tile[][]> previousStates = new Stack<>();
    private boolean isGameWon = false;
    private boolean isGameLost = false;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon(boolean gameWon) {
        isGameWon = gameWon;
    }

    public boolean isGameLost() {
        return isGameLost;
    }

    public void setGameLost(boolean gameLost) {
        isGameLost = gameLost;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] gameTiles) {
        Tile[][] saveStateTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                int value = gameTiles[i][j].getValue();
                saveStateTiles[i][j] = new Tile(value);
            }
        }
        previousStates.push(saveStateTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            score = previousScores.pop();
            gameTiles = previousStates.pop();
        }
    }

    public boolean canMove() {
        boolean canMove = false;
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                if (gameTiles[x][y].getValue() == 0) {
                    canMove = true;
                    break;
                }
            }
        }
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                if (x > 0 && y > 0) {
                    if (gameTiles[x][y].getValue() == gameTiles[x - 1][y].getValue() || gameTiles[x][y].getValue() == gameTiles[x][y - 1].getValue()) {
                        canMove = true;
                        break;
                    }
                } else if (x < FIELD_WIDTH - 1 && y < FIELD_WIDTH - 1) {
                    if (gameTiles[x][y].getValue() == gameTiles[x + 1][y].getValue() || gameTiles[x][y].getValue() == gameTiles[x][y + 1].getValue()) {
                        canMove = true;
                        break;
                    }
                }
            }
        }
        return canMove;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean create = false;
        for (Tile[] tileRow : gameTiles) {
            if (compressTiles(tileRow)) {
                if (!create) create = true;
            }
            if (mergeTiles(tileRow)) {
                if (!create) create = true;
            }
        }
        if (create) addTile();
        isSaveNeeded = true;
    }

    private void rotateClockwise() {
        Tile[][] rotateMatrix = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int x = 0, i = 0; x < FIELD_WIDTH; x++, i++) {
            for (int y = 0, j = FIELD_WIDTH - 1; y < FIELD_WIDTH; y++, j--) {
                rotateMatrix[i][j] = gameTiles[y][x];

            }
        }
        gameTiles = rotateMatrix;
    }

    public void up() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }

    public void right() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }

    public void down() {
        saveState(gameTiles);
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public boolean hasBoardChanged() {
        Tile[][] lastState = previousStates.peek();
        int currentSumOfValues = 0, lastStateSumOfValues = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                currentSumOfValues += gameTiles[i][j].getValue();
                lastStateSumOfValues += lastState[i][j].getValue();
            }
        }
        return currentSumOfValues != lastStateSumOfValues;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        if (!hasBoardChanged()) {
            rollback();
            return new MoveEfficiency(-1, 0, move);
        }

        int emptyTilesCount = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTilesCount++;
                }
            }
        }

        rollback();
        return new MoveEfficiency(emptyTilesCount, score, move);
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::down));

        priorityQueue.peek().getMove().move();
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        int hash = Arrays.hashCode(tiles);
        Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
        return hash != Arrays.hashCode(tiles);
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMoved = false;
        int newValue;
        for (int i = 0; i < tiles.length - 1; i++) {
            Tile currentTile = tiles[i];
            Tile nextTile = tiles[i + 1];
            if (currentTile.getValue() == nextTile.getValue() && !currentTile.isEmpty()) {
                newValue = currentTile.getValue() * 2;
                currentTile.setValue(newValue);
                nextTile.setValue(0);
                score += newValue;
                if (newValue > maxTile) {
                    maxTile = newValue;
                }
                if (!isMoved) isMoved = true;
            }
        }
        compressTiles(tiles);
        return isMoved;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            Tile tile = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
            tile.setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        return Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .filter(Tile::isEmpty).collect(Collectors.toList());
    }

    void resetGameTiles() {
        score = 0;
        maxTile = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
}

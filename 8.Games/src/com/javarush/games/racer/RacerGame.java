package com.javarush.games.racer;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private int score;
    private boolean isGameStopped;
    private FinishLine finishLine;
    private PlayerCar player;
    private ProgressBar progressBar;
    private RoadManager roadManager;
    private RoadMarking roadMarking;

    @Override
    public void setCellColor(int x, int y, Color color) {
        if ((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT)) {
            super.setCellColor(x, y, color);
        }
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x < ROADSIDE_WIDTH || x >= WIDTH - ROADSIDE_WIDTH) {
                    setCellColor(x, y, Color.GREEN);
                } else if (x != CENTER_X) {
                    setCellColor(x, y, Color.DIMGREY);
                } else {
                    setCellColor(x, y, Color.WHITE);
                }
            }
        }
    }

    private void moveAll() {
        progressBar.move(roadManager.getPassedCarsCount());
        finishLine.move(player.speed);
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        player.move();
    }

    @Override
    public void onTurn(int step) {
        score -= 5;
        setScore(score);
        if (roadManager.checkCrush(player)) {
            gameOver();
        } else if (finishLine.isCrossed(player)) {
            win();
        } else {
            if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) finishLine.show();
            moveAll();
            roadManager.generateNewRoadObjects(this);
        }
        drawScene();
    }

    private void drawScene() {
        drawField();
        progressBar.draw(this);
        roadMarking.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        player.draw(this);
    }

    private void createGame() {
        score = 3500;
        setScore(score);
        setTurnTimer(40);
        isGameStopped = false;
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        roadManager = new RoadManager();
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        drawScene();
    }

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case SPACE:
                if (isGameStopped) createGame();
                break;
            case UP:
                player.speed = 2;
                break;
            case RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                player.setDirection(Direction.LEFT);
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case UP:
                player.speed = 1;
                break;
            case LEFT:
                if (player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);
                break;
            case RIGHT:
                if (player.getDirection() == Direction.RIGHT) player.setDirection(Direction.NONE);
                break;
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game over", Color.BLACK, 20);
        stopTurnTimer();
        player.stop();
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.BLACK, 20);
        stopTurnTimer();
    }
}

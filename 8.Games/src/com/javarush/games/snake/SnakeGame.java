package com.javarush.games.snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private int turnDelay;
    private int score;
    private boolean isGameStopped;
    private Snake snake;
    private Apple apple;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (!snake.isAlive) {
            gameOver();
        }
        if (snake.getLength() > GOAL) {
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case SPACE:
                if (isGameStopped) createGame();
        }
    }

    private void drawScene() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        boolean isCollision = true;
        while (isCollision) {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
            if (!snake.checkCollision(apple)) {
                isCollision = false;
            }
        }
    }

    private void createGame() {
        isGameStopped = false;
        score = 0;
        setScore(score);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        drawScene();
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game over", Color.BLACK, 12);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.BLACK, 12);
    }
}

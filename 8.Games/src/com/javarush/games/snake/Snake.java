package com.javarush.games.snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public int x;
    public int y;
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;
    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;

        GameObject one = new GameObject(x, y);
        GameObject two = new GameObject(x + 1, y);
        GameObject three = new GameObject(x + 2, y);

        snakeParts.add(one);
        snakeParts.add(two);
        snakeParts.add(three);
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void setDirection(Direction direction) {
        if (direction == Direction.LEFT && this.direction == Direction.RIGHT) return;
        if (direction == Direction.UP && this.direction == Direction.DOWN) return;
        if (direction == Direction.RIGHT && this.direction == Direction.LEFT) return;
        if (direction == Direction.DOWN && this.direction == Direction.UP) return;
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x)
            return;
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y)
            return;
        this.direction = direction;
    }

    public boolean checkCollision(GameObject gameObject) {
        boolean isCollision = false;
        for (GameObject snakePart : snakeParts) {
            if (snakePart.x == gameObject.x && snakePart.y == gameObject.y) {
                isCollision = true;
                break;
            }
        }
        return isCollision;
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (isAlive) {
                if (i == 0) {
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, Color.BLACK, 75);
                } else {
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.BLACK, 75);
                }
            } else {
                if (i == 0) {
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, Color.RED, 75);
                } else {
                    game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.RED, 75);
                }
            }
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT || checkCollision(newHead)) {
            isAlive = false;
        } else {
            snakeParts.add(0, newHead);
            if (newHead.x == apple.x && newHead.y == apple.y) {
                apple.isAlive = false;
            } else {
                removeTail();
            }
        }
    }

    public GameObject createNewHead() {
        GameObject gameObject = null;
        switch (direction) {
            case LEFT:
                gameObject = new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
                break;
            case DOWN:
                gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
                break;
            case RIGHT:
                gameObject = new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
                break;
            case UP:
                gameObject = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
                break;
        }
        return gameObject;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}

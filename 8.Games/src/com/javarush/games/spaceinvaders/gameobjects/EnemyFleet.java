package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    private double getSpeed() {
        return Math.min(2.0, (3.0 / ships.size()));
    }

    public void move() {
        if (!ships.isEmpty()) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                for (EnemyShip enemyShip : ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
            } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                for (EnemyShip enemyShip : ships) {
                    enemyShip.move(Direction.DOWN, getSpeed());
                }
            } else {
                for (EnemyShip enemyShip : ships) {
                    enemyShip.move(direction, getSpeed());
                }
            }
        }
    }

    public int getShipsCount() {
        return ships.size();
    }

    public double getBottomBorder() {
        double max = Double.MIN_VALUE;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.y + enemyShip.height > max) {
                max = enemyShip.y + enemyShip.height;
            }
        }
        return max;
    }

    private double getLeftBorder() {
        double min = Double.MAX_VALUE;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.x < min) {
                min = enemyShip.x;
            }
        }
        return min;
    }

    private double getRightBorder() {
        double max = Double.MIN_VALUE;
        for (EnemyShip enemyShip : ships) {
            if (enemyShip.x + enemyShip.width > max) {
                max = enemyShip.x + enemyShip.width;
            }
        }
        return max;
    }

    public void draw(Game game) {
        for (EnemyShip enemyShip : ships) {
            enemyShip.draw(game);
        }
    }

    public Bullet fire(Game game) {
        if (!ships.isEmpty()) {
            int randomNumber = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
            if (randomNumber > 0) {
                return null;
            } else {
                int randomShip = game.getRandomNumber(ships.size());
                return ships.get(randomShip).fire();
            }
        } else {
            return null;
        }
    }

    public int verifyHit(List<Bullet> bullets) {
        if (!bullets.isEmpty()) {
            int score = 0;
            for (Ship ship : ships) {
                for (Bullet bullet : bullets) {
                    if (bullet.isCollision(ship)) {
                        if (ship.isAlive && bullet.isAlive) {
                            if (ship instanceof Boss) {
                                score += ((Boss) ship).score;
                            } else if (ship instanceof EnemyShip) {
                                score += ((EnemyShip) ship).score;
                            }
                            ship.kill();
                            bullet.kill();
                        }
                    }
                }
            }
            return score;
        } else {
            return 0;
        }
    }

    public void deleteHiddenShips() {
        ships.removeIf(ship -> !ship.isVisible());
    }
}

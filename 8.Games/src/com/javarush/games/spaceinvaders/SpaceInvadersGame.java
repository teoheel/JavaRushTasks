package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private boolean isGameStopped;
    private int animationsCount;
    private int score;
    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private EnemyFleet enemyFleet;
    private PlayerShip playerShip;

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < WIDTH; y++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void drawScene() {
        drawField();
        playerShip.draw(this);
        enemyFleet.draw(this);
        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.draw(this);
        }
        for (Bullet playerBullet : playerBullets) {
            playerBullet.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<>();
        stars.add(new Star(1, 1));
        stars.add(new Star(10, 10));
        stars.add(new Star(19, 19));
        stars.add(new Star(28, 28));
        stars.add(new Star(36, 36));
        stars.add(new Star(45, 45));
        stars.add(new Star(54, 54));
        stars.add(new Star(63, 63));
    }

    private void createGame() {
        setTurnTimer(40);
        score = 0;
        setScore(score);
        isGameStopped = false;
        animationsCount = 0;
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        createStars();
        drawScene();
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        playerShip.move();
        for (Bullet enemyBullet : enemyBullets) {
            enemyBullet.move();
        }
        for (Bullet playerBullet : playerBullets) {
            playerBullet.move();
        }
    }

    private void removeDeadBullets() {
        enemyBullets.removeIf(enemyBullet -> !enemyBullet.isAlive || enemyBullet.y >= HEIGHT - 1);
        playerBullets.removeIf(playerBullet -> !playerBullet.isAlive || playerBullet.y + playerBullet.height < 0);
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        score += enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0) {
            stopGameWithDelay();
            playerShip.win();
        }
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if ((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT)) {
            super.setCellValueEx(x, y, cellColor, value);
        }
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        Bullet enemyBullet = enemyFleet.fire(this);
        if (enemyBullet != null) {
            enemyBullets.add(enemyBullet);
        }
        check();
        setScore(score);
        drawScene();
    }

    private void stopGame(boolean isWin) {
        stopTurnTimer();
        isGameStopped = true;
        if (isWin) {
            showMessageDialog(Color.WHITE, "You win!", Color.GREEN, 20);
        } else {
            showMessageDialog(Color.WHITE, "Game over!", Color.RED, 20);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                createGame();
            }
        } else {
            if (key == Key.SPACE) {
                Bullet playerBullet = playerShip.fire();
                if (playerBullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                    playerBullets.add(playerBullet);
                }
            } else if (key == Key.LEFT) {
                playerShip.setDirection(Direction.LEFT);
            } else if (key == Key.RIGHT) {
                playerShip.setDirection(Direction.RIGHT);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        } else if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }
}

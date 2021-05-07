package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (!model.canMove()) {
            model.setGameLost(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            model.rollback();
        }
        if (!model.isGameLost() && !model.isGameWon()) {
            if (e.getKeyCode() == KeyEvent.VK_A) model.autoMove();
            if (e.getKeyCode() == KeyEvent.VK_R) model.randomMove();
            if (e.getKeyCode() == KeyEvent.VK_LEFT) model.left();
            if (e.getKeyCode() == KeyEvent.VK_UP) model.up();
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) model.right();
            if (e.getKeyCode() == KeyEvent.VK_DOWN) model.down();
        }
        if (model.maxTile == WINNING_TILE) model.setGameWon(true);
        view.repaint();
    }

    public void resetGame() {
        model.setGameLost(false);
        model.setGameWon(false);
        model.resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }
}

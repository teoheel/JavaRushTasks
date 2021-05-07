package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {
    public boolean isAlive = true;
    private boolean loopAnimation = false;
    private List<int[][]> frames;
    private int frameIndex;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        frames = new ArrayList<>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
        frames = Arrays.asList(viewFrames);
        setMatrix(viewFrames[0]);
        frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void nextFrame() {
        frameIndex++;
        if (loopAnimation && frameIndex == frames.size()) {
            frameIndex = 0;
        }
        if (frameIndex < frames.size()) {
            matrix = frames.get(frameIndex);
        }
    }

    public boolean isVisible() {
        return isAlive || frames.size() > frameIndex;
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }
}

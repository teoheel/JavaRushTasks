package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private static final int PLAYER_CAR_DISTANCE = 12;
    private int passedCarsCount = 0;
    private List<RoadObject> items = new ArrayList<>();

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        RoadObject roadObject = null;
        switch (type) {
            case THORN:
                roadObject = new Thorn(x, y);
                break;
            case DRUNK_CAR:
                roadObject = new MovingCar(x, y);
                break;
            default:
                roadObject = new Car(type, x, y);
                break;
        }
        return roadObject;
    }

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject = createRoadObject(type, x, y);
        if (roadObject != null && isRoadSpaceFree(roadObject)) {
            items.add(roadObject);
        }
    }

    public void draw(Game game) {
        for (RoadObject item : items) {
            item.draw(game);
        }
    }

    public void move(int boost) {
        for (RoadObject item : items) {
            item.move(boost + item.speed, items);
        }
        deletePassedItems();
    }

    private boolean isThornExists() {
        boolean isThorn = false;
        for (RoadObject item : items) {
            if (item.type.equals(RoadObjectType.THORN)) {
                isThorn = true;
                break;
            }
        }
        return isThorn;
    }

    private boolean isMovingCarExists() {
        boolean isMovingCar = false;
        for (RoadObject item : items) {
            if (item.type.equals(RoadObjectType.DRUNK_CAR)) {
                isMovingCar = true;
                break;
            }
        }
        return isMovingCar;
    }

    private void generateThorn(Game game) {
        int randomNumber = game.getRandomNumber(100);
        if (randomNumber < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    private void generateMovingCar(Game game) {
        int randomNumber = game.getRandomNumber(100);
        if (randomNumber < 10 && !isMovingCarExists()) {
            addRoadObject(RoadObjectType.DRUNK_CAR, game);
        }
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    private void generateRegularCar(Game game) {
        int randomNumber = game.getRandomNumber(100);
        int carTypeNumber = game.getRandomNumber(4);
        if (randomNumber < 30) {
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
        }
    }

    private void deletePassedItems() {
//        for (RoadObject item : items) {
//            if (item.y >= RacerGame.HEIGHT) {
//                if(!(item.type.equals(RoadObjectType.THORN))) { passedCarsCount++; }
//                items.remove(item);
//            }
//        }
//        Iterator iterator = items.iterator();
//        while(iterator.hasNext()){
//            RoadObject item = (RoadObject)iterator.next();
//            if(item.y >= RacerGame.HEIGHT){
//                if(!(item instanceof Thorn)) passedCarsCount++;
//                iterator.remove();
//            }
//        }

        for (Iterator<RoadObject> iterator = items.iterator(); iterator.hasNext(); ) {
            RoadObject item = iterator.next();
            if (item.y >= RacerGame.HEIGHT) {
                if (!(item instanceof Thorn)) passedCarsCount++;
                iterator.remove();
            }
        }
    }

    public boolean checkCrush(PlayerCar player) {
        boolean isCrush = false;

        for (RoadObject item : items) {
            if (item.isCollision(player)) {
                isCrush = true;
                break;
            }
        }

        return isCrush;
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        boolean isFree = true;
        for (RoadObject item : items) {
            if (item.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) {
                isFree = false;
                break;
            }
        }
        return isFree;
    }
}

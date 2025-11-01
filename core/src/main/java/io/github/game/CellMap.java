package io.github.game;


import java.util.ArrayList;

public class CellMap {
    private ArrayList<Entity>[][] map;

    public CellMap(int mapHeight, int mapWidth) {
        map = new ArrayList[mapHeight][mapWidth];
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
    }

    public int putEntity(Entity entity, int x, int y) {
        if (!(y < 0 || y >= map.length) && !(x < 0 || x >= map[y].length)) {
            map[y][x].add(entity);
            return 0;
        } else {
            return 1;
        }

    }

    public void moveEntity(Entity entity, int direction)
    {
        if (map[entity.getY()][entity.getX()].contains(entity)) {
            // remove from the previous cell array

            // put in another cell array
            if (direction == 1){
                if(putEntity(entity, entity.getX()+1, entity.getY()) == 0) {
                    map[entity.getY()][entity.getX()].remove(entity);
                    entity.moveHorizontally(1);
                }
            } else if (direction == -1) {
                if (putEntity(entity, entity.getX()-1, entity.getY()) == 0) {
                    map[entity.getY()][entity.getX()].remove(entity);
                    entity.moveHorizontally(-1);
                }
            } else if (direction == 2) {
                if (putEntity(entity, entity.getX(), entity.getY() + 1) == 0) {
                    map[entity.getY()][entity.getX()].remove(entity);
                    entity.moveVertically(1);
                }
            } else if (direction == -2) {
                if (putEntity(entity, entity.getX(), entity.getY() - 1) == 0) {
                    map[entity.getY()][entity.getX()].remove(entity);
                    entity.moveVertically(-1);
                }

            }
        }

        debug();
    }


    private void debug() {
        System.out.println();
        for (int i = map.length-1; i >= 0; i--) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

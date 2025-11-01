package io.github.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private FitViewport viewport;
    private Array<Entity> entities;
    private Entity player;
    private Entity wall;
    private CellMap map;
    private final int worldWidth = 10;
    private final int worldHeight = 10;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Entity(1, 10, false, new Sprite(new Texture("player.png")));


        viewport = new FitViewport(worldWidth, worldHeight);

        map = new CellMap(worldHeight, worldWidth);
        map.putEntity(player, 0, 0);

        for (int i = 0; i < worldWidth; i++) {
            map.putEntity(new Entity(2, 1000, true, new Sprite(new Texture("wall.png"))), i, worldHeight - 1);
        }
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void logic() {
    }

    private void input() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            map.moveEntity(player, 2);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            map.moveEntity(player, -2);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            map.moveEntity(player, 1);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            map.moveEntity(player, -1);
        }
    }

    public void draw(){
        ScreenUtils.clear(Color.BLACK);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        {

//            batch.draw(player.getSprite(), player.getX(), player.getY(), 1, 1);

            for (int i = 0; i < worldHeight; i++) {
                for (int j = 0; j < worldWidth; j++) {
                    for (Entity entity : map.getEntitiesOnCoordinates(i, j)) {
                        batch.draw(entity.getSprite(), entity.getX(), entity.getY(), 1, 1);
                    }
                }
            }


        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }

}

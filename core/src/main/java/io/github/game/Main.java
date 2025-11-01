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

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private FitViewport viewport;
    private Array<Entity> entities;
    private Entity player;
    private CellMap map;
    private final int worldWidth = 10;
    private final int worldHeight = 6;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Entity(1, 10, new Sprite(new Texture("player.png")));


        viewport = new FitViewport(worldWidth, worldHeight);

        map = new CellMap(worldHeight, worldWidth);
        map.putEntity(player, 0, 0);
        map.putEntity(new Entity(2, 100, new Sprite(new Texture("player.png"))), 0, 0);

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

            batch.draw(player.getSprite(), player.getX(), player.getY(), 1, 1);
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

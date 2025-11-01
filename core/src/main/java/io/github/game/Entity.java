package io.github.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {
    private int id;
    private int health;
    private Sprite sprite;
    private int x;
    private int y;

    public Entity(int id, int health, Sprite sprite)
    {
        this.id = id;
        this.health = health;
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void moveHorizontally(int direction) {
        this.x += direction;
    }

    public void moveVertically(int direction) {
        this.y += direction;
    }
}

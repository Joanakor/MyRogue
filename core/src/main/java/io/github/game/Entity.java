package io.github.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {
    private int id;
    private int health;
    private Sprite sprite;
    private int x;
    private int y;
    private boolean isCollidable;

    public Entity(int id, int health, boolean isCollidable, Sprite sprite)
    {
        this.id = id;
        this.health = health;
        this.sprite = sprite;
        this.isCollidable = isCollidable;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveHorizontally(int direction) {
        this.x += direction;
    }

    public void moveVertically(int direction) {
        this.y += direction;
    }
}

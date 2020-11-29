package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;

public abstract class MovingEntity extends Entity {
    protected int desX = x;
    protected int desY = y;
    protected int speed;
    protected boolean alive;
    protected int left = 0;
    protected int right = 0;
    protected int up = 0;
    protected int down = 0;

    public MovingEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        alive = true;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void goLeft() {
        desX = x - speed;
    }

    public void goRight() {
        desX = x + speed;
    }
    public void goUp() {
        desY = y - speed;
    }

    public void goDown() {
        desY = y + speed;
    }

    public void move() {
        x = desX;
        y = desY;
    }

    public void stay() {
        desX = x;
        desY = y;
    }

    public Rectangle getDesBounds() {
        return new Rectangle(desX, desY, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public boolean isAlive() {
        return alive;
    }
}
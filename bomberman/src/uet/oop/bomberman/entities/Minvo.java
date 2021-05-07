package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class Minvo extends Enemy {
    private int direction;
    protected Bomber bomber;
    Random random = new Random();

    public Minvo(int xUnit, int yUnit, Image img, Bomber bomber) {
        super(xUnit, yUnit, img);
        this.bomber = bomber;
        setLayer(1);
        setSpeed(4);
        generateDirection();
        alive = true;
    }

    public void goLeft() {
        super.goLeft();
        img = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, left++, 18).getFxImage();
    }

    public void goRight() {
        super.goRight();
        img = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, right++, 18).getFxImage();
    }

    public void goUp() {
        super.goUp();
        img = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, up++, 18).getFxImage();
    }

    public void goDown() {
        super.goDown();
        img = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, down++, 18).getFxImage();
    }

    @Override
    public void stay() {
        super.stay();
    }

    @Override
    public void update() {
        if(isAlive()) {
            if(x % Sprite.SCALED_SIZE == 0 && y % Sprite.SCALED_SIZE == 0) {
                generateDirection();
            }
            if (direction == 0) goLeft();
            if (direction == 1) goRight();
            if (direction == 2) goUp();
            if (direction == 3) goDown();
        }else if(animated < 30){
            animated++;
            img = Sprite.minvo_dead.getFxImage();
        }else
            BombermanGame.enemies.remove(this);
    }

    public void generateDirection() {
        int vertical = random.nextInt(2);

        if(vertical == 1) {
            int v = calculateRowDirection();
            if(v != -1)
                direction = v;
            else
                direction = calculateColDirection();

        } else {
            int h = calculateColDirection();

            if(h != -1)
                direction = h;
            else
                direction = calculateRowDirection();
        }
    }

    private int calculateColDirection() {
        if(bomber.x < x)
            return 0;
        else if(bomber.x > x)
            return 1;

        return -1;
    }

    private int calculateRowDirection() {
        if(bomber.y < y)
            return 2;
        else if(bomber.y > y)
            return 3;
        return -1;
    }
}

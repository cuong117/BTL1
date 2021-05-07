package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class SpeedItem extends Item {
    public SpeedItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void powerUp(Bomber bomber) {
        super.powerUp(bomber);
        bomber.setSpeed(bomber.getSpeed() + 1);
    }

    @Override
    public void update() {

    }
}

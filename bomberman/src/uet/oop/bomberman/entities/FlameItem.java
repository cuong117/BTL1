package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Sound;

public class FlameItem extends Item {
    public FlameItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void powerUp(Bomber bomber) {
        super.powerUp(bomber);
        bomber.setPower(bomber.getPower() + 1);
    }

    @Override
    public void update() {

    }
}

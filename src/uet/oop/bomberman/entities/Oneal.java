package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Oneal extends Enemy {
    public Oneal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {
        if(isAlive()){

        }else if(animated < 30){
            animated++;
            img = Sprite.oneal_dead.getFxImage();
        }else
            BombermanGame.enemies.remove(this);
    }
}

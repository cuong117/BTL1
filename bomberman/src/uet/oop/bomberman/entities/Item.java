package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Sound;

public abstract class Item extends StillEntity {
    public Item(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(1);
    }

    public void powerUp(Bomber bomber){
        Sound.get_item.play();
        Sound.get_item.seek(Sound.get_item.getStartTime());
    }
}

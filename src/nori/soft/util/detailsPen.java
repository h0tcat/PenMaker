package nori.soft.util;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;
import java.io.Serializable;

public class detailsPen implements Serializable {
    private static final long detailsPenSerialPen = 10L;
    Image drawBrushImage;

    public detailsPen(Image drawBrushImage) {
        this.drawBrushImage = drawBrushImage;
    }

    public void draw(GraphicsContext graphCont, double drawX, double drawY) {
        graphCont.drawImage(this.drawBrushImage, drawX, drawY);
    }
}

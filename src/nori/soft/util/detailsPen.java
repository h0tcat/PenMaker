package nori.soft.util;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public class detailsPen implements Serializable {
    private static final long detailsPenSerialPen = 10L;
    String drawBrushImage;

    public detailsPen(String drawBrushImage) {
        this.drawBrushImage = drawBrushImage;
    }

    public void draw(GraphicsContext graphCont, double drawX, double drawY) {
        graphCont.drawImage(new Image("file:"+this.drawBrushImage), drawX, drawY);
    }
}

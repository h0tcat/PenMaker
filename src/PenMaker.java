import javafx.scene.image.Image;
import nori.soft.util.detailsPen;

import java.io.*;

public class PenMaker {
    public static void main(String[] args) {
        if (!(args.length == 2)) {
            System.out.println("Usage: PenMaker imageFile outputFileName");
        } else {
            System.out.println("Build nori file...");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(args[1]+".nori");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream objOutputStream = null;
            try {
                objOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            detailsPen penPlugin = new detailsPen(new Image("file:"+args[0]));
            try {
                objOutputStream.writeObject(penPlugin);
                System.out.println("D 0 N E !");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    objOutputStream.flush();
                    objOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}
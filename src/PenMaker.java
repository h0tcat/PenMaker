import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import nori.soft.util.detailsPen;

import java.io.*;

public class PenMaker extends Application {

    public void start(Stage primaryStage) throws Exception {
        String[] args = new String[2];

        System.out.print("使用する画像ファイルのパスを入力: ");
        args[0]=new java.util.Scanner(System.in).nextLine();
        System.out.print("保存するファイル名を入力　※拡張子は自動でつきます: ");
        args[1]=new java.util.Scanner(System.in).nextLine();

        System.out.println("Build nori file...");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(args[1] + ".nori");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objOutputStream = null;
        try {
            objOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        detailsPen penPlugin = new detailsPen(new Image(new File(args[0]).toURI().toString()));
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
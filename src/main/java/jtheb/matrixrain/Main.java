package jtheb.matrixrain;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main extends Application {
    static final int width = 800;
    static final int height = 600;

    static List<String> list = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        loadList();

        primaryStage.setTitle("Matrix");
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        CharList[] chArr = IntStream.range(0, 70).mapToObj(i -> new CharList()).toArray(CharList[]::new);

        new AnimationTimer() {
            public void handle(long now) {

                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, width, height);
                IntStream.range(0, chArr.length).forEach(i -> chArr[i].render(gc));

            }

        }.start();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }


    public static void loadList() throws FileNotFoundException {


        String fileName = "character.txt";
        String directory = System.getProperty("user.dir");
        Path startingDir = Paths.get(directory);

        FileSearch fileSearch = new FileSearch();
        File file = fileSearch.searchDirectory(startingDir, fileName);

        if (file != null) {
            System.out.println("File found at: " + file.getAbsolutePath());
            Scanner s = new Scanner(file.getAbsoluteFile());
            list = new ArrayList<>();
            while (s.hasNext()) list.add(s.next());
            s.close();
        } else {
            System.out.println("File not found in the directory tree.");
            System.exit(0);
        }

    }
}

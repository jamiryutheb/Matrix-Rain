package jtheb.matrixrain;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.stream.IntStream;

public class CharList {


    Char[] chars;
    int y;
    int x;
    int speed;
    int distance;
    int fontSize;
    int width = Main.width;
    int positioner;

    public CharList() {

        distance = (int) (Math.random() * 5);
        fontSize = distance * 5;
        positioner = fontSize;
        y = (int) (Math.random() * -200);
        x = (int) (Math.random() * width);
        speed = (int) ((Math.random() * 2) + distance / 2);
//        chars = new Char[(int) (Math.random() * 30) + 15];
        chars = new Char[50];

        IntStream.range(0, chars.length).forEach(i -> {
            chars[i] = new Char(x, y);
            y -= positioner;
        });

    }


    public void render(GraphicsContext g2) {


        g2.setFont(new Font("", fontSize));
        g2.setFill(Color.rgb(0, 220, 0));

        for (int i = 0; i < chars.length; i++) {
            chars[i].render(g2);
            chars[i].rain(speed);
            if (Math.random() < 0.007)
                chars[i].reset();
        }

    }


}

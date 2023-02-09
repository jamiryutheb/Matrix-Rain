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

    public CharList() {

        distance = (int) (Math.random() * 5);
        fontSize = distance * 5;
        y = (int) (Math.random() * -200);
        x = (int) (Math.random() * Main.width);
        speed = (int) ((Math.random() * 2) + distance / 2);
        chars = new Char[50];

        IntStream.range(0, chars.length).forEach(i -> {
            chars[i] = new Char(x, y);
            y -= fontSize;
        });
    }

    public void render(GraphicsContext g2) {
        g2.setFont(new Font("", fontSize));
        g2.setFill(Color.rgb(0, 220, 0));

        for (Char ch : chars) {
            ch.render(g2);
            ch.rain(speed);
            if (Math.random() < 0.007) ch.reset();
        }
    }
}

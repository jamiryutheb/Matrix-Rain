package jtheb.matrixrain;

import javafx.scene.canvas.GraphicsContext;

public class Char{

    int x;
    int y;
    int index;
    int size;
    String text;

    public Char(int x, int y)  {
        this.size = Main.list.size();
        this.index = (int) (Math.random() * size);
        this.text = Main.list.get(index);
        this.x = x;
        this.y = y;
    }

    public void rain(int speed) {
        if(y > Main.height){
            y = -200;
        }else{
            y += speed;
        }
    }

    public void render(GraphicsContext g2) {
        g2.fillText(text, x, y);
    }


    public void reset() {
        this.index = (int) (Math.random() * size);
        this.text = Main.list.get(index);
    }
}

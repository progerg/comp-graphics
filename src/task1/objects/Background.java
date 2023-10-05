package task1.objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Background implements Drawable {
    private final int width, height;
    private final Color color;
    private final Collection<Drawable> objects;

    public Background(int width, int height, Color color, Collection<Drawable> objects) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.objects = objects;
    }

    public Background(int width, int height, Color color) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.objects = new ArrayList<>();
    }

    public Background(int width, int height, Collection<Drawable> objects) {
        this.color = Color.CYAN;
        this.width = width;
        this.height = height;
        this.objects = objects;
    }

    public Background(int width, int height) {
        this.color = Color.CYAN;
        this.width = width;
        this.height = height;
        this.objects = new ArrayList<>();
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(color);
        gr.drawRect(0, 0, width, height);
        gr.fillRect(0, 0, width, height);
        for (Drawable object: objects) {
            object.draw(gr);
        }
    }
}

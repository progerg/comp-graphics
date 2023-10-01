package task1.objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Background implements Drawable {
    private final Sun sun;
    private final List<Cloud> clouds = new ArrayList<>();
    private final int width, height;

    public Background(int width, int height) {
        this.width = width;
        this.height = height;
        this.sun = new Sun(width - 150, -150, 300, 300, 15, 100);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            this.clouds.add(new Cloud(i * 125, random.nextInt(height / 6), 150, 75));
        }
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(Color.cyan);
        gr.drawRect(0, 0, width, height);
        gr.fillRect(0, 0, width, height);
        sun.draw(gr);
        for (Cloud cloud: clouds) {
            cloud.draw(gr);
        }
    }
}

package task1.objects;

import java.awt.*;

public class Grass implements Drawable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;

    public Grass(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Grass(final int x, final int y, final int width, final int height) {
        this(x, y, width, height, Color.GREEN);
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw(final Graphics2D g) {
        g.setColor(this.color);
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
    }
}

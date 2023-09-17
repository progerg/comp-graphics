package objects;

import java.awt.*;

public class Grass implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Grass(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Grass(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.GREEN;
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

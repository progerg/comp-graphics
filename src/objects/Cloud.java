package objects;

import java.awt.*;

public class Cloud implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Cloud(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.WHITE;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);

        // Рассчитываем размеры и позиции каждого овала на основе общей длины и ширины
        int ovalWidth = width / 3;
        int ovalHeight = height / 2;

        int xOffset1 = width / 10;
        int xOffset2 = width / 4;
        int xOffset3 = width / 2;

        int yOffsetUpper = height / 8;
        int yOffsetLower = height * 3 / 8;

        g.fillOval(x + xOffset1, y + yOffsetUpper, ovalWidth, ovalHeight);
        g.fillOval(x + xOffset2, y, ovalWidth, ovalHeight);
        g.fillOval(x + xOffset2, y + yOffsetLower, ovalWidth, ovalHeight);
        g.fillOval(x + xOffset3, y + yOffsetUpper, ovalWidth, ovalHeight);
    }
}

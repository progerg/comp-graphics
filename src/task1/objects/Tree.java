package task1.objects;

import java.awt.*;

public class Tree implements Drawable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int radius;
    private final Color foliageColor;
    private final Color trunkColor;

    /**
     * x - x coord of trunk left up corner
     * y - y coord of trunk left up corner - radius / 2
     * width - some const value. total width is
     */
    public Tree(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = width / 2;
        this.foliageColor = new Color(34, 139, 34); // Зеленый цвет для листвы
        this.trunkColor = new Color(139, 69, 19);  // Коричневый цвет для ствола
    }

    @Override
    public void draw(final Graphics2D g) {
        g.setColor(trunkColor);
        g.fillRect(x + (radius / 8), y + radius / 2, width / 3, height / 2);

        int offsetX = radius / 3 * 2;
        int offsetY = (int) (radius / 2.1);

        g.setColor(foliageColor);
        g.fillOval(x - radius / 2, y, radius, radius);
        g.fillOval(x + radius - offsetX, y, radius, radius);
        g.fillOval(x - radius / 2, y - radius + offsetY, radius, radius);
        g.fillOval(x + radius - offsetX, y - radius + offsetY, radius, radius);
        g.fillOval(x - radius / 2, y - (int) (radius * 1.5) + offsetY, radius, radius);
        g.fillOval(x + radius - offsetX, y - (int) (radius * 1.5) + offsetY, radius, radius);
        g.fillOval(x, y - 2 * radius + offsetY, radius, radius);
    }
}


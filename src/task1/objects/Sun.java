package task1.objects;

import java.awt.*;

public class Sun implements Drawable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;
    private final int n; // количество лучей
    private final int l; // длина лучей

    public Sun(int x, int y, int width, int height, Color color, int n, int l) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.n = n;
        this.l = l;
    }

    public Sun(int x, int y, int width, int height, int n, int l) {
        this(x, y, width, height, Color.YELLOW, n, l);
    }

    @Override
    public void draw(final Graphics2D g) {
        g.setColor(this.color);
        g.drawOval(x, y, width, height);
        g.fillOval(x, y, width, height);

        // Добавляем лучи
        int r = width / 2; // радиус солнца
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double a = i * da;
            double x1 = r * Math.cos(a) + (x + r);
            double y1 = r * Math.sin(a) + (y + r);
            double x2 = (r + l) * Math.cos(a) + (x + r);
            double y2 = (r + l) * Math.sin(a) + (y + r);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }
}

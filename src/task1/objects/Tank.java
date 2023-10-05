package task1.objects;

import java.awt.*;

public class Tank implements Drawable{
    private int x;
    private final int y;
    private final int width, height;
    private final Color firstColor, secondColor, strokeColor;

    public Tank(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.firstColor = new Color(69, 102, 0);
        this.secondColor = new Color(178, 180, 63);
        this.strokeColor = new Color(66, 52, 28);
    }

    @Override
    public void draw(Graphics2D g) {
        this.x += 1;

        // Drawing the tracks
        g.drawRoundRect(x, height / 2 + y, width, height / 2, width / 2, width / 2);
        g.setColor(firstColor);
        g.fillRoundRect(x, height / 2 + y, width, height / 2, width / 2, width / 2);

        g.setStroke(new BasicStroke(10));
        g.setColor(strokeColor);
        g.drawRoundRect(x + width / 6, (int) (height / 1.6) + y, (int) (width / 1.5), height / 4, width / 3, width / 3);
        g.setColor(secondColor);
        g.fillRoundRect(x + width / 6, (int) (height / 1.6) + y, (int) (width / 1.5), height / 4, width / 3, width / 3);

        g.setColor(secondColor);
        g.fillRect(x + width / 4, y, width / 2, height / 2);

        g.setStroke(new BasicStroke(20));
        g.setColor(strokeColor);
        g.drawLine(x + width / 4 * 3, y + height / 4, x + width, y);
    }

}

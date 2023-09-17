package objects;

import java.awt.*;

public class Amogus implements Drawable {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Amogus(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void draw(final Graphics2D g) {
        // bag
        g.setColor(this.color);
        g.fillOval(this.x, (int)(this.y + 0.25 * this.height), (int)(0.33 * this.width), (int)(0.5 * this.height));
        g.setColor(Color.BLACK);
        g.drawOval(this.x, (int)(this.y + 0.25 * this.height), (int)(0.33 * this.width), (int)(0.5 * this.height));

        // head
        g.setColor(this.color);
        g.fillOval((int)(this.x + 0.2 * this.width), this.y, (int)(0.75 * this.width), (int)(0.5 * height));
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.2 * this.width), this.y, (int)(0.75 * this.width), (int)(0.5 * height));

        // legs
        g.setColor(this.color);
        g.fillRect((int)(this.x + 0.2 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.5 * this.height));
        g.fillRect((int)(this.x + 0.65 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.5 * this.height));
        g.setColor(Color.BLACK);
        g.drawRect((int)(this.x + 0.2 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.5 * this.height));
        g.drawRect((int)(this.x + 0.65 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.5 * this.height));

        // body
        g.setColor(this.color);
        g.fillRect((int)(this.x + 0.2 * this.width), (int)(this.y + 0.25 * this.height),
                (int)(0.75 * this.width), (int)(0.5 * this.height));
        g.setColor(Color.BLACK);
        g.drawLine((int)(this.x + 0.2 * this.width), (int)(this.y + 0.25 * this.height),
                (int)(this.x + 0.2 * this.width), (int)(this.y + 0.75 * this.height));
        g.drawLine((int)(this.x + 0.95 * this.width), (int)(this.y + 0.25 * this.height),
                (int)(this.x + 0.95 * this.width), (int)(this.y + 0.75 * this.height));
        g.drawLine((int)(this.x + 0.45 * this.width), (int)(this.y + 0.75 * this.height),
                (int)(this.x + 0.7 * this.width),(int)(this.y + 0.75 * this.height));

        // eyes
        g.setColor(new Color(135,206,250));
        g.fillOval((int)(this.x + 0.5 * this.width), (int)(this.y + 0.16 * this.height),
                (int)(0.55 * this.width), (int)(0.25 * this.height));
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.5 * this.width), (int)(this.y + 0.16 * this.height),
                (int)(0.55 * this.width), (int)(0.25 * this.height));
    }
}
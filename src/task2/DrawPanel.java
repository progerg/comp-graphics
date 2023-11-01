package task2;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel{

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final Drawable[] drawables;

    public DrawPanel(final int width, final int height, Drawable... drawables) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;

        this.drawables = drawables;
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.PLAIN, 29));
        g.drawString("Дуга окружности с интерполяцией цвета", 8, 50);

        for (Drawable drawable: drawables) {
            drawable.draw(g);
        }
    }
}
package objects;

import java.awt.*;

public class Tank implements Drawable {
    private int x, y, width, height;
    private Color firstColor, secondColor, strokeColor;

    public Tank(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.firstColor = new Color(69, 102, 0);
        this.secondColor = new Color(178, 180, 63);
        this.strokeColor = new Color(66, 52, 28);
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void draw(Graphics2D g) {
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
        g.fillRect(x + (int) (width / 4), y, width / 2, height / 2);

        g.setStroke(new BasicStroke(20));
        g.setColor(strokeColor);
        g.drawLine(x + width / 4 * 3, y + height / 4, x + width, y);
        //        g.setColor(trackColor);
//        int trackWidth = width / 6;
//        g.fillRect(x, y, trackWidth, height); // Left track
//        g.fillRect(x + width - trackWidth, y, trackWidth, height); // Right track

//        // Drawing the body of the tank
//        g.setColor(bodyColor);
//        g.fillRect(x + trackWidth, y + height / 6, width - 2 * trackWidth, 2 * height / 3);
//
//        // Drawing the cannon
//        g.setColor(cannonColor);
//        int cannonWidth = width / 4;
//        int cannonHeight = height / 4;
//        g.fillRect(x + width / 2 - cannonWidth / 2, y + height / 3 - cannonHeight / 2, cannonWidth, cannonHeight);
    }

}

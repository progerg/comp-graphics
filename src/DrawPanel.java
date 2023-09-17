import objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;

    private Amogus amogus;
    private Grass grass;
    private Sun sun;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Tank tank;
    private List<Cloud> clouds = new ArrayList<>();

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();

        this.grass = new Grass(0, height - 200, width, 200);
        this.sun = new Sun(width - 150, -150, 300, 300, 15, 100);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            this.clouds.add(new Cloud(i * 125, random.nextInt(height / 6), 150, 75));
        }
        this.tree1 = new Tree(300, grass.getY() - 150, 200, 300);
        this.tree2 = new Tree(80, grass.getY() - 50, 200, 300);
        this.tree3 = new Tree(500, grass.getY(), 200, 300);
        //this.amogus = new Amogus(ticksFromStart, height - 360, 200, 260, Color.BLACK);
        this.tank = new Tank(0, grass.getY(), 200, 100);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        gr.setColor(Color.cyan);
        gr.drawRect(0, 0, getWidth(), getHeight());
        gr.fillRect(0, 0, getWidth(), getHeight());
        sun.draw(g);
        for (Cloud cloud: clouds) {
            cloud.draw(g);
        }
        grass.draw(g);
        tree1.draw(g);
        tank.setX(ticksFromStart);
        tank.draw(g);
        tree2.draw(g);
        tree3.draw(g);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}
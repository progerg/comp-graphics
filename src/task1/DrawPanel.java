package task1;

import task1.objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {
    private final Timer timer;
    private int ticksFromStart = 0;
    private final Grass grass;
    private final Tree tree1;
    private final Tree tree2;
    private final Tree tree3;
    private final Tank tank;
    private final Background background;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        timer = new Timer(timerDelay, this);
        timer.start();

        this.grass = new Grass(0, height - 200, width, 200);
        this.tree1 = new Tree(300, grass.getY() - 150, 200, 300);
        this.tree2 = new Tree(80, grass.getY() - 50, 200, 300);
        this.tree3 = new Tree(500, grass.getY(), 200, 300);
        this.tank = new Tank(0, grass.getY(), 200, 100);
        this.background = new Background(width, height);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        background.draw(g);
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
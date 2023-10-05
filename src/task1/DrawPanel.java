package task1;

import task1.objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener {
    private final Timer timer;
    private final List<Drawable> objects;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        timer = new Timer(timerDelay, this);
        timer.start();

        Grass grass = new Grass(0, height - 200, width, 200);
        Tree tree1 = new Tree(300, grass.getY() - 150, 200, 300);
        Tree tree2 = new Tree(80, grass.getY() - 50, 200, 300);
        Tree tree3 = new Tree(500, grass.getY(), 200, 300);
        Tank tank = new Tank(0, grass.getY(), 200, 100);

        List<Drawable> backgroundObjects = new ArrayList<>();
        Sun sun = new Sun(width - 150, -150, 300, 300, 15, 100);
        backgroundObjects.add(sun);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            backgroundObjects.add(new Cloud(i * 125, random.nextInt(height / 6), 150, 75));
        }

        Background background = new Background(width, height, backgroundObjects);
        objects = List.of(background, grass, tree1, tank, tree2, tree3);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        for (Drawable object: objects) {
            object.draw(g);
        }
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }
}
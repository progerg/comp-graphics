package task2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height) throws HeadlessException {
        CircleArc circleArc = new CircleArc(
                new Bresenham(100, 275, 300, 0, 180),
                new Interpolation(Color.BLUE, Color.RED, 0, 180)
        );

        DrawPanel panel = new DrawPanel(width, height, circleArc);
        this.add(panel);
    }
}
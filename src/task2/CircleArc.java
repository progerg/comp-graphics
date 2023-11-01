package task2;

import java.awt.Graphics2D;
import java.awt.Color;

public class CircleArc implements Drawable {

    // Определение переменных для координат центра окружности, радиуса, начального и конечного углов и цветов
    private final AlgorithmArc algorithm;

    private final PointColor pointColor;


    // Конструктор класса CircleArc
    public CircleArc(AlgorithmArc algorithm, PointColor pointColor) {
        this.pointColor =  pointColor;
        this.algorithm = algorithm;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.drawLine(algorithm.getCenterX() - algorithm.getRadius() - 100,
                algorithm.getCenterY(),
                algorithm.getCenterX() + algorithm.getRadius() + 100,
                algorithm.getCenterY());
        gr.drawLine(algorithm.getCenterX(),
                algorithm.getCenterY() - algorithm.getRadius() - 100,
                algorithm.getCenterX(),
                algorithm.getCenterY() + algorithm.getRadius() + 100);
        for (Point point: algorithm.getPoints()) {
            int angle = normalizeAngle((int) Math.toDegrees(Math.atan2(algorithm.getCenterY() - point.getY(),
                    point.getX() - algorithm.getCenterX())));
            putPixel(gr, point.getX(), point.getY(), pointColor.getColor(angle));
        }
    }

    // Метод для нормализации угла в диапазоне [0, 360)
    private int normalizeAngle(int angle) {
        if (angle < 0) angle = 360 + angle;  // преобразование отрицательных углов в соответствующие положительные углы
        return angle % 360;
    }

    // Метод для рисования пикселя с заданным цветом
    private void putPixel(Graphics2D g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}

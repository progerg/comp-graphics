package task2;

import java.util.LinkedList;
import java.util.List;

public class Bresenham implements AlgorithmArc {
    private final int centerX, centerY, startAngle, endAngle, radius;

    private final List<Point> points = new LinkedList<>();
    
    public Bresenham(int radius, int centerX, int centerY, int startAngle, int endAngle) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.radius = radius;
    }

    @Override
    public List<Point> getPoints() {
        process();
        return points;
    }

    private void process() {
        int x = radius;
        int y = 0;
        int p = 1 - radius;

        // Алгоритм Брезенхема для рисования окружности
        while (x >= y) {
            y++;

            // Вычисление параметра решения p
            if (p <= 0) {
                p = p + 2 * y + 1;
            } else {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }

            // Рисуем точки в 4 квадрантах
            checkAndDrawPixel(x + centerX, y + centerY);   // 1-й квадрант
            checkAndDrawPixel(-x + centerX, y + centerY);  // 2-й квадрант
            checkAndDrawPixel(-x + centerX, -y + centerY); // 3-й квадрант
            checkAndDrawPixel(x + centerX, -y + centerY);  // 4-й квадрант

            // Рисуем дополнительные точки, если x не равно y
            if (x != y) {
                checkAndDrawPixel(y + centerX, x + centerY);
                checkAndDrawPixel(-y + centerX, x + centerY);
                checkAndDrawPixel(-y + centerX, -x + centerY);
                checkAndDrawPixel(y + centerX, -x + centerY);
            }
        }

        checkAndDrawPixel(centerX + radius, centerY);  // 0 градусов
        checkAndDrawPixel(centerX, centerY - radius);  // 90 градусов
        checkAndDrawPixel(centerX - radius, centerY);  // 180 градусов
        checkAndDrawPixel(centerX, centerY + radius);  // 270 градусов
    }

    // Метод для проверки и рисования пикселя на основе угла
    private void checkAndDrawPixel(int x, int y) {
        int angle = normalizeAngle((int) Math.toDegrees(Math.atan2(centerY - y, x - centerX)));
        if (isAngleInRange(angle)) {
            putPixel(x, y);
        }
    }

    // Метод для нормализации угла в диапазоне [0, 360)
    private int normalizeAngle(int angle) {
        if (angle < 0) angle = 360 + angle;  // преобразование отрицательных углов в соответствующие положительные углы
        return angle % 360;
    }

    @Override
    public int getCenterX() {
        return centerX;
    }

    @Override
    public int getCenterY() {
        return centerY;
    }

    @Override
    public int getRadius() {
        return radius;
    }

    private boolean isAngleInRange(int angle) {
        return angle >= startAngle && angle <= endAngle + 1;
    }

    private void putPixel(int x, int y) {
        this.points.add(new Point(x, y));
    }
}

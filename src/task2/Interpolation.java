package task2;

import java.awt.*;

public class Interpolation implements PointColor{
    private final Color startColor;
    private final Color endColor;
    private final int startAngle;
    private final int endAngle;

    public Interpolation(Color startColor, Color endColor, int startAngle, int endAngle) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }


    // Метод для вычисления цвета пикселя на основе угла
    public Color getColor(int angle) {
        float fraction = (float) (angle - startAngle) / (endAngle - startAngle);
        int redStart = startColor.getRed();
        int greenStart = startColor.getGreen();
        int blueStart = startColor.getBlue();
        int redEnd = endColor.getRed();
        int greenEnd = endColor.getGreen();
        int blueEnd = endColor.getBlue();

        int red = (int) (redStart + fraction * (redEnd - redStart));
        int green = (int) (greenStart + fraction * (greenEnd - greenStart));
        int blue = (int) (blueStart + fraction * (blueEnd - blueStart));

        // Обеспечиваем, чтобы цветовые значения находились в диапазоне [0, 255]
        red = Math.max(0, Math.min(255, red));
        green = Math.max(0, Math.min(255, green));
        blue = Math.max(0, Math.min(255, blue));

        return new Color(red, green, blue);
    }
}

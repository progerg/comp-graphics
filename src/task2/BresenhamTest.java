package task2;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BresenhamTest {

    private Bresenham bresenham;

    @Before
    public void setUp() {
        bresenham = new Bresenham(50, 100, 100, 0, 90);
    }

    @Test
    public void testGetPoints() {
        List<Point> points = bresenham.getPoints();

        // Проверим, что список точек не пустой
        assertFalse(points.isEmpty());
    }

    @Test
    public void testFullCircle() {
        Bresenham fullCircle = new Bresenham(50, 100, 100, 0, 360);
        List<Point> points = fullCircle.getPoints();
        assertFalse(points.isEmpty());
    }

}

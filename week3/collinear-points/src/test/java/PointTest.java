import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class PointTest {

    @Test public void compareTo_with_different_y() {
        assertEquals(1, new Point(2, 3).compareTo(new Point(1, 2)));
    }

    @Test public void compareTo_with_same_y() {
        assertEquals(1, new Point(2, 3).compareTo(new Point(1, 3)));
    }

    @Test public void slopeTo_diagonal_asc() {
        double slope = new Point(1, 1).slopeTo(new Point(2, 2));
        assertEquals(1d, slope, 0.01d);
    }

    @Test public void slopeTo_horz() {
        double slope = new Point(1, 1).slopeTo(new Point(2, 1));
        assertEquals(0d, slope, 0.01d);
    }

    @Test public void slopeTo_vert() {
        double slope = new Point(1, 1).slopeTo(new Point(1, 2));
        assertTrue(Double.isInfinite(slope));
    }

    @Test public void slopeTo_degenerate() {
        double slope = new Point(1, 1).slopeTo(new Point(1, 1));
        assertEquals(Double.NEGATIVE_INFINITY, slope, 0.01d);
    }

    @Test public void slopeOrder_p1_major_than_p2() {
        Comparator<Point> slopeOrder = new Point(2, 2).slopeOrder();
        assertEquals(1, slopeOrder.compare(new Point(3, 3), new Point(3, 1)));
    }

}
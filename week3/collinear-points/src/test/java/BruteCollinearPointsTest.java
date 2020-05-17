import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BruteCollinearPointsTest {

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_null_params() {
        new BruteCollinearPoints(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_null_point() {
        new BruteCollinearPoints(new Point[]{ null });
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_duplicates() {
        new BruteCollinearPoints(new Point[]{ new Point(1, 1),
            new Point(1, 1) });
    }

    @Test
    public void different_segments() {
        Point p = new Point(1, 1);
        Point q = new Point(2, 1);
        Point r = new Point(2, 2);
        Point s = new Point(1, 2);
        BruteCollinearPoints bcp = new BruteCollinearPoints(new Point[]{p, q, r, s});
        assertEquals(4, bcp.numberOfSegments());
        assertEquals(new LineSegment(p, q), bcp.segments()[0]);
        assertEquals(new LineSegment(q, r), bcp.segments()[1]);
        assertEquals(new LineSegment(r, s), bcp.segments()[2]);
        assertEquals(new LineSegment(s, p), bcp.segments()[3]);
    }

}
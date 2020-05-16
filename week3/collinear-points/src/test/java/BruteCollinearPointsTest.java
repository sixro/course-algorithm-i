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

}
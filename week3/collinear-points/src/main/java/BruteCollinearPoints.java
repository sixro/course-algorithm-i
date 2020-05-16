public class BruteCollinearPoints {
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("points are are required");
        for (Point p: points)
            if (p == null)
                throw new IllegalArgumentException("no point null please");
        // FIXME impl
    }

    // the number of line segments
    public int numberOfSegments() {
        // FIXME impl
        return 0;
    }

    // the line segments
    public LineSegment[] segments() {
        // FIXME impl
        return null;
    }
}

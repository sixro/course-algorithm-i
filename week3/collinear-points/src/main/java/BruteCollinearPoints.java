public class BruteCollinearPoints {

    private final LineSegment[] segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("points are are required");
        for (Point p: points)
            if (p == null)
                throw new IllegalArgumentException("no point null please");
        if (points[0].compareTo(points[1]) == 0 || points[0].compareTo(points[2]) == 0 || points[0].compareTo(points[3]) == 0 || points[1].compareTo(points[2]) == 0 || points[1].compareTo(points[3]) == 0 || points[2].compareTo(points[3]) == 0)
            throw new IllegalArgumentException("found duplicates");

        segments = new LineSegment[4];
        double slopePQ = points[0].slopeTo(points[1]);
        double slopeQR = points[1].slopeTo(points[2]);
        double slopeRS = points[2].slopeTo(points[3]);
        double slopeSP = points[2].slopeTo(points[3]);
        
        if (slopeRS == slopeQR)
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return segments;
    }
}

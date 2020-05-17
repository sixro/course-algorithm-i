import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BruteCollinearPoints {

    private final LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {

        checkNull(points);
        Point[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints);
        checkDuplicate(sortedPoints);

        final int N = points.length;
        List<LineSegment> list = new LinkedList<>();

        for (int a = 0; a < N - 3; a++) {
            Point ptA = sortedPoints[a];

            for (int b = a + 1; b < N - 2; b++) {
                Point ptB = sortedPoints[b];
                double slopeAB = ptA.slopeTo(ptB);

                for (int c = b + 1; c < N - 1; c++) {
                    Point ptC = sortedPoints[c];
                    double slopeAC = ptA.slopeTo(ptC);
                    if (slopeAB == slopeAC) {

                        for (int d = c + 1; d < N; d++) {
                            Point ptD = sortedPoints[d];
                            double slopeAD = ptA.slopeTo(ptD);
                            if (slopeAB == slopeAD) {
                                list.add(new LineSegment(ptA, ptD));
                            }
                        }
                    }
                }
            }
        }
        segments = list.toArray(new LineSegment[0]);
    }

    private void checkNull(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("points are required");
        }
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException("all points required");
            }
        }
    }

    private void checkDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicate(s) found.");
            }
        }
    }

    /**
     * The number of line segments.
     */
    public int numberOfSegments() {
        return segments.length;
    }

    /**
     * The line segments.
     */
    public LineSegment[] segments() {
        return segments.clone();
    }

    /**
     * Code provided in the assignment for FastCollinearPoints slighty modified
     * in order to use BruteCollinearPoints.
     */
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}

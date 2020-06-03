import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;

import java.util.TreeSet;

public class PointSET {

    private final TreeSet<Point2D> tree;

    public PointSET() {
        tree = new TreeSet<Point2D>();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public int size() {
        return tree.size();
    }

    public void insert(Point2D p) {
        tree.add(p);
    }

    public boolean contains(Point2D p) {
        return tree.contains(p);
    }

    // draw all points
    public void draw() {
        for (Point2D p : tree) {
            p.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        Stack<Point2D> set = new Stack<>();
        for (Point2D p : tree) {
            if (p.x() >= rect.xmin()
                && p.x() <= rect.xmax()
                && p.y() >= rect.ymin()
                && p.y() <= rect.ymax()) {

                set.push(p);
            }
        }

        return set;
    }

    public Point2D nearest(Point2D that) {

        double dist = Float.MAX_VALUE;
        Point2D nearest = null;
        for (Point2D p : tree) {
            double distanceTo = p.distanceSquaredTo(that);
            if (distanceTo < dist) {
                dist = distanceTo;
                nearest = p;
            }
        }

        return nearest;
    }

}

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {

    private Node root;
    private int size;

    public KdTree() {
        size = 0;
        root = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean insert(Node node, Point2D p, boolean isX) {

        if (node.point.equals(p)) {
            return false;
        }

        if (isX) {

            if (node.point.x() > p.x()) {
                if (node.left != null) {
                    return insert(node.left, p, false);
                } else {
                    node.left = new Node(p);
                    node.left.parent = node;
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.point.x(), node.rect.ymax());
                }
            } else {
                if (node.right != null) {
                    return insert(node.right, p, false);
                } else {
                    node.right = new Node(p);
                    node.right.parent = node;
                    node.right.rect = new RectHV(node.point.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax());
                }
            }
        } else {
            if (node.point.y() > p.y()) {
                if (node.left != null) {
                    return insert(node.left, p, true);
                } else {
                    node.left = new Node(p);
                    node.left.parent = node;
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.point.y());
                }
            } else {
                if (node.right != null) {
                    return insert(node.right, p, true);
                } else {
                    node.right = new Node(p);
                    node.right.parent = node;
                    node.right.rect = new RectHV(node.rect.xmin(), node.point.y(), node.rect.xmax(), node.rect.ymax());
                }
            }

        }
        return true;
    }

    private boolean insert(Node rootNode, Point2D p) {
        return insert(rootNode, p, true);
    }

    public void insert(Point2D p) {
        if (root == null) {
            root = new Node(p);
            root.rect = new RectHV(0, 0, 1, 1);
            size = 1;
            return;
        }

        if (insert(root, p)) {
            size += 1;
        }
    }

    private boolean contains(Node node, Point2D p, boolean isX) {

        if (node == null) {
            return false;
        }

        if (node.point.equals(p)) {
            return true;
        }

        if (isX) {
            if (node.point.x() > p.x())
                return contains(node.left, p, false);
            else {
                return contains(node.right, p, false);
            }

        } else {
            if (node.point.y() > p.y()) {
                return contains(node.left, p, true);
            } else {
                return contains(node.right, p, true);
            }
        }
    }

    private boolean contains(Node rootNode, Point2D p) {
        return contains(rootNode, p, true);
    }

    public boolean contains(Point2D p) {
        if (isEmpty()) {
            return false;
        }

        return contains(root, p);
    }

    private void draw(Node rootNode, boolean isX) {
        if (rootNode == null) {
            return;
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        rootNode.point.draw();

        StdDraw.setPenRadius();
        if (isX) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(rootNode.point.x(), rootNode.rect.ymin(), rootNode.point.x(), rootNode.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(rootNode.rect.xmin(), rootNode.point.y(), rootNode.rect.xmax(), rootNode.point.y());
        }

        draw(rootNode.left, !isX);
        draw(rootNode.right, !isX);
    }

    public void draw() {
        draw(root, true);
    }

    private void range(Node node, RectHV rect, Stack<Point2D> stack) {
        Point2D p = node.point;
        if (p.x() >= rect.xmin() && p.x() <= rect.xmax() && p.y() >= rect.ymin() && p.y() <= rect.ymax()) {
            stack.push(p);
        }

        if (node.left != null && rect.intersects(node.left.rect)) {
            range(node.left, rect, stack);
        }

        if (node.right != null && rect.intersects(node.right.rect)) {
            range(node.right, rect, stack);
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        Stack<Point2D> stack = new Stack<>();
        if (isEmpty()) {
            return stack;
        }

        range(root, rect, stack);
        return stack;
    }


    private Point2D nearest(Node node, Point2D p, double minimal, boolean isX) {

        if (!(node.rect.distanceSquaredTo(p) < minimal)) {
            return null;
        }

        Point2D nearest = null;
        double dist = node.point.distanceSquaredTo(p);
        if (dist < minimal) {
            minimal = dist;
            nearest = node.point;
        }

        if (isX) {

            if (p.x() < node.point.x()) {

                Point2D left = node.left != null ? nearest(node.left, p, minimal, false) : null;
                double leftDist = left != null ? left.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (leftDist < minimal) {
                    minimal = leftDist;
                    nearest = left;
                }

                Point2D right = node.right != null ? nearest(node.right, p, minimal, false) : null;
                double rightDist = right != null ? right.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (rightDist < minimal) {
                    nearest = right;
                }

            } else {

                Point2D right = node.right != null ? nearest(node.right, p, minimal, false) : null;
                double rightDist = right != null ? right.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (rightDist < minimal) {
                    minimal = rightDist;
                    nearest = right;
                }

                Point2D left = node.left != null ? nearest(node.left, p, minimal, false) : null;
                double leftDist = left != null ? left.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (leftDist < minimal) {
                    nearest = left;
                }

            }

        } else {

            if (p.y() < node.point.y()) {

                Point2D left = node.left != null ? nearest(node.left, p, minimal, true) : null;
                double leftDist = left != null ? left.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (leftDist < minimal) {
                    minimal = leftDist;
                    nearest = left;
                }

                Point2D right = node.right != null ? nearest(node.right, p, minimal, true) : null;
                double rightDist = right != null ? right.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (rightDist < minimal) {
                    nearest = right;
                }

            } else {

                Point2D right = node.right != null ? nearest(node.right, p, minimal, true) : null;
                double rightDist = right != null ? right.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (rightDist < minimal) {
                    minimal = rightDist;
                    nearest = right;
                }

                Point2D left = node.left != null ? nearest(node.left, p, minimal, true) : null;
                double leftDist = left != null ? left.distanceSquaredTo(p) : Double.POSITIVE_INFINITY;

                if (leftDist < minimal) {
                    nearest = left;
                }
            }
        }

        return nearest;
    }

    public Point2D nearest(Point2D that) {
        return nearest(root, that, Double.POSITIVE_INFINITY, true);
    }

    private static class Node {
        Point2D point;
        Node left;
        Node right;
        Node parent;
        RectHV rect;

        Node(Point2D point) {
            this.point = point;
            left = null;
            right = null;
            parent = null;
            rect = null;
        }
    }

}

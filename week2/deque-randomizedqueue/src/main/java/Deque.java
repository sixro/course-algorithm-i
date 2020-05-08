import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;

    public Deque() {
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null && last == null;
    }

    // return the number of items on the deque
    public int size() {
        return 0;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item is required");

        Node<Item> old = first;
        first = new Node<>();
        first.item = item;
        first.prev = null;
        first.next = old;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item is required");
        Node<Item> old = last;
        last = new Node<>();
        last.item = item;
        last.prev = old;
        last.next = null;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item ret = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        return ret;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item ret = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        return ret;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

    private static class Node<Item> {
        private Item item;
        private Deque.Node<Item> prev;
        private Deque.Node<Item> next;

        private Node() {
        }

    }
}

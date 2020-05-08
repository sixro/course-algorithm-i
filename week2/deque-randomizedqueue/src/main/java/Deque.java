import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item is required");

        Node<Item> old = first;
        first = new Node<>(item);
        first.next = old;
        if (size != 0) {
            old.prev = first;
        } else {
            last = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item is required");
        Node<Item> old = last;
        last = new Node<>(item);
        last.prev = old;
        if (size != 0) {
            old.next = last;
        } else {
            first = last;
        }

        size++;
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
        size--;
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
        size--;
        return ret;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Deque.NodeIterator<>(first);
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> d = new Deque<>();
        d.addFirst("A");
        StdOut.println(d.removeLast());
        d.addLast("B");
        StdOut.println(d.removeFirst());
        d.addFirst("B");
        d.addLast("C");
        d.addFirst("A");
        for (String each: d) {
            StdOut.println(each);
        }
    }

    private static class Node<Item> {
        private final Item item;
        private Deque.Node<Item> prev;
        private Deque.Node<Item> next;

        private Node(Item i) {
            this.item = i;
        }

        @Override
        public String toString() {
           return "Node{" + "item=" + item + ", prev=" + (prev != null ?
                prev.item : null) + ", " +
                "next=" + (next != null ? next.item : null) + '}';
        }
    }

    private static class NodeIterator<Item> implements Iterator<Item> {
        private final Node<Item> first;
        private Node<Item> curr;

        NodeIterator(Node<Item> first) {
            this.first = first;
            this.curr = null;
        }

        @Override
        public boolean hasNext() {
            return curr == null || curr.next != null;
        }

        @Override
        public Item next() {
            if (curr == null) {
                curr = first;
            } else {
                curr = curr.next;
            }
            if (curr == null)
                throw new NoSuchElementException();
            return curr.item;
        }
    }
}

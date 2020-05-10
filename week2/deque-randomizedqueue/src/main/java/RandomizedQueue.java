import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    public RandomizedQueue() {
        this.first = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        size++;
        if (first == null) {
            first = new Node<>(item);
            return;
        }

        Node<Item> old = first;
        first = new Node<>(item);
        first.next = old;
    }

    public Item dequeue() {
        size--;

        int idx = randomIdx();
        if (idx == 0) {
            Item value = first.item;
            first = first.next;
            return value;
        }
        Node<Item> prevnode = nodeAt(idx -1);
        Item value = prevnode.next.item;
        prevnode.next = prevnode.next.next;
        return value;
    }

    public Item sample() {
        int idx = randomIdx();
        Node<Item> node = nodeAt(idx);
        return node.item;
    }

    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    private Node<Item> nodeAt(int idx) {
        int i = 0;
        Node<Item> cursor = first;
        while (i++ < idx) cursor = cursor.next;
        return cursor;
    }

    protected int randomIdx() {
        return StdRandom.uniform(size);
    }

    @Override
    public String toString() {
        return "RandomizedQueue{size=" + size + ", first=" + first + "}";
    }

    private static class Node<Item> {
        private final Item item;
        private Node<Item> prev;
        private Node<Item> next;

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

}

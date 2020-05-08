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

        if (item.equals("1")) {
            System.out.println("DEBUG");
        }
        Node<Item> old = first;
        first = new Node(item);
        first.next = old;
        if (old != null) {
            old.prev = first;
        }
        if (size == 0) {
            last = first;
        } else if (size == 1) {
            last = old;
            last.prev = first;
        }
        System.out.println("addFirst DEBUG: last: " + last + ", first: " + first);
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item is required");
        Node<Item> old = last;
        last = new Node<>(item);
        last.prev = old;
        if (old != null) {
            old.next = last;
        }

        if (size == 0) {
            first = last;
        } else if (size == 1) {
            first = old;
            first.next = last;
        }
        System.out.println("addLast DEBUG: last: " + last + ", first: " + first);
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        System.out.println("removeFirst DEBUG: last: " + last + ", first: " + first);
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

        System.out.println("removeLast DEBUG: last: " + last + ", first: " + first);

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
        return null;
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

    private static class Node<Item> {
        private Item item;
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
//            return "Node{" + "item=" + item + ", prev=" + prev + ", " +
//                "next=" + next + '}';
        }
    }
}

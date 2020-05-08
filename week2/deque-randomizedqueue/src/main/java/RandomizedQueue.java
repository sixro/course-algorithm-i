import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return true;
    }

    // return the number of items on the randomized queue
    public int size() {
        return 0;
    }

    // add the item
    public void enqueue(Item item) {
        throw new UnsupportedOperationException();
    }

    // remove and return a random item
    public Item dequeue() {
        throw new UnsupportedOperationException();
    }

    // return a random item (but do not remove it)
    public Item sample() {
        throw new UnsupportedOperationException();
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException();
    }

    // unit testing (required)
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

}

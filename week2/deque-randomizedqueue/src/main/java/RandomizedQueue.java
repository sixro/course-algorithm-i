import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    public RandomizedQueue() {
        this.items = (Item[]) new Object[1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item is required");

        if (size == items.length)
            enlarge();
        items[size] = item;
        size++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("empty");

        int idx = randomIdx();
        Item ret = items[idx];
        size--;

        items[idx] = items[size];
        items[size] = null;
        if (size <= items.length / 4)
            shrink();

        return ret;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("empty");

        return items[randomIdx()];
    }

    private void enlarge() {
        resize(items.length * 2);
    }

    private void shrink() {
        resize(items.length / 2);
    }

    private void resize(int newSize) {
        Item[] resized = (Item[]) new Object[newSize];
        for (int i = 0; i < items.length; i++)
            resized[i] = items[i];
        items = resized;
    }

    public Iterator<Item> iterator() {
        return new It<>(items, size);
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    private int randomIdx() {
        while (true) {
            int idx = StdRandom.uniform(size);
            if (items[idx] != null)
                return idx;
        }
    }

    private static class It<Item> implements Iterator<Item> {

        private final Item[] copied;
        private int index;

        It(Item[] source, int size) {
            this.copied = (Item[]) new Object[size];
            System.arraycopy(source, 0, copied, 0, size);

            for (int i = 1; i < copied.length; i++) {
                int randomIdx = StdRandom.uniform(i + 1);

                Item tmp = copied[i];
                copied[i] = copied[randomIdx];
                copied[randomIdx] = tmp;
            }
        }

        @Override
        public boolean hasNext() {
            return index < copied.length;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Item ret = copied[index];
            index++;
            return ret;
        }
    }
}

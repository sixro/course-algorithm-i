import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    @Test
    public void enqueue_and_sample() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        String sample = rq.sample();
        assertEquals(3, rq.size());
        assertTrue(sample.equals("A") || sample.equals("B") || sample.equals("C"));
    }

    @Test
    public void enqueue_and_deque() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        String sample = rq.dequeue();
        assertEquals(2, rq.size());
        assertTrue(sample.equals("A") || sample.equals("B") || sample.equals("C"));
    }

    @Test
    public void iterator() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        String sample = rq.iterator().next();
        assertTrue(sample.equals("A") || sample.equals("B") || sample.equals("C"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void enqueue_null() {
        new RandomizedQueue<String>().enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeue_when_empty() {
        new RandomizedQueue<String>().dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void sample_when_empty() {
        new RandomizedQueue<String>().sample();
    }

    @Test
    public void enq_1_element() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(20);
        rq.dequeue();
    }

    @Test public void multiple_iterators() {
        int n = 100;
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }
    }
}
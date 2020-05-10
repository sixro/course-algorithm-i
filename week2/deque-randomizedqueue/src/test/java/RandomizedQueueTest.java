import org.junit.Test;

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
    public void random_pos_is_0() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>() {
            @Override
            protected int randomIdx() {
                return 0;
            }
        };
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        String sample = rq.dequeue();
        assertEquals(2, rq.size());
        assertEquals("C", sample);
    }

    // TODO gestire caso idx e' size-1

}
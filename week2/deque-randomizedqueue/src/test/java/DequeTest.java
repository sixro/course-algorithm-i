import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    @Test(expected = IllegalArgumentException.class)
    public void addFirst_with_null_param() {
        Deque<String> d = new Deque<>();
        d.addFirst(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLast_with_null_param() {
        Deque<String> d = new Deque<>();
        d.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirst_when_empty() {
        Deque<String> d = new Deque<>();
        d.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLast_when_empty() {
        Deque<String> d = new Deque<>();
        d.removeLast();
    }

    @Test
    public void add_and_remove_first() {
        Deque<String> d = new Deque<>();
        d.addFirst("Hello world");
        assertEquals("Hello world", d.removeFirst());
    }

    @Test
    public void add_and_remove_last() {
        Deque<String> d = new Deque<>();
        d.addLast("Hello world");
        assertEquals("Hello world", d.removeLast());
    }

    // TODO add first remove last
    // TODO add last remove first
    // TODO iterator
    // TODO iterator exception mentioned in the assignment
    // TODO main as expected by assignment

}
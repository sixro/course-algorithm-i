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

    @Test
    public void add_first_and_remove_last() {
        Deque<String> d = new Deque<>();
        d.addFirst("Hello world");
        assertEquals("Hello world", d.removeLast());
    }

    @Test
    public void add_last_and_remove_first() {
        Deque<String> d = new Deque<>();
        d.addLast("Hello world");
        assertEquals("Hello world", d.removeFirst());
    }

    @Test
    public void intermixed_additions() {
        Deque<String> d = new Deque<>();
        d.addFirst("2");
        d.addLast("3");
        d.addFirst("1");
        assertEquals("3", d.removeLast());
        assertEquals("2", d.removeLast());
        assertEquals("1", d.removeLast());
    }

    // TODO iterator
    // TODO iterator exception mentioned in the assignment
    // TODO main as expected by assignment

}
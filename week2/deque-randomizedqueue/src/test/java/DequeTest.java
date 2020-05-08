import org.junit.Test;

import java.util.Iterator;
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
    public void intermixed_additions_and_removes_all_using_removeLast() {
        Deque<String> d = new Deque<>();
        d.addFirst("2");
        d.addLast("3");
        d.addFirst("1");
        assertEquals("3", d.removeLast());
        assertEquals("2", d.removeLast());
        assertEquals("1", d.removeLast());
        assertTrue(d.isEmpty());
    }

    @Test
    public void intermixed_additions_removes_all_using_removeFirst() {
        Deque<String> d = new Deque<>();
        d.addFirst("2");
        d.addLast("3");
        d.addFirst("1");
        assertEquals("1", d.removeFirst());
        assertEquals("2", d.removeFirst());
        assertEquals("3", d.removeLast());
        assertTrue(d.isEmpty());
    }

    @Test
    public void intermixed_additions_and_removals() {
        Deque<String> d = new Deque<>();
        d.addFirst("2");
        d.addLast("3");
        d.addFirst("1");
        assertEquals("3", d.removeLast());
        assertEquals("1", d.removeFirst());
        assertEquals("2", d.removeLast());
        assertTrue(d.isEmpty());
        d.addFirst("5");
        d.addLast("6");
        d.addFirst("7");
        assertEquals("6", d.removeLast());
        assertEquals("7", d.removeFirst());
        assertEquals("5", d.removeLast());
    }

    @Test
    public void iterator() {
        Deque<String> d = new Deque<>();
        d.addFirst("2");
        d.addLast("3");
        d.addFirst("1");
        Iterator<String> it = d.iterator();
        assertEquals("1", it.next());
        assertEquals("2", it.next());
        assertEquals("3", it.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_without_any_next() {
        Deque<String> d = new Deque<>();
        d.addFirst("1");
        Iterator<String> it = d.iterator();
        assertEquals("1", it.next());
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_when_empty() {
        Deque<String> d = new Deque<>();
        Iterator<String> it = d.iterator();
        it.next();
    }

    // TODO main as expected by assignment

}
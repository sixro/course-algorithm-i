import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {

    @Test public void open() {
        Percolation p = new Percolation(1);
        assertFalse(p.isOpen(1, 1));
        assertTrue(p.isFull(1, 1));

        p.open(1, 1);

        assertTrue(p.isOpen(1, 1));
        assertFalse(p.isFull(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_n_minor_than_0() {
        new Percolation(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_n_equals_to_0() {
        new Percolation(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void is_Open_with_row_minor_than_1() {
        new Percolation(1).isOpen(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void is_Open_with_col_minor_than_1() {
        new Percolation(1).isOpen(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void is_Open_with_row_major_than_N() {
        new Percolation(1).isOpen(2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void is_Open_with_col_major_than_N() {
        new Percolation(1).isOpen(1, 2);
    }

    // throw isOpen/open/isFull x/y < 1 or > N

}
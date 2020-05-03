import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {

    @Test public void open() {
        Percolation p = new Percolation(1);
        assertFalse(p.isOpen(1, 1));

        p.open(1, 1);

        assertTrue(p.isOpen(1, 1));
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

    @Test
    public void is_Full() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        assertFalse(p.isFull(2, 1));
        p.open(2, 1);
        assertTrue(p.isFull(2, 1));
    }

    @Test
    public void percolates_2_2() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 1);
        assertTrue(p.percolates());
        assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    public void do_not_percolate_2_2() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 2);
        assertFalse(p.percolates());
        assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    public void percolates_5_5_with_open_sites_in_horz() {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(2, 1);
        p.open(3, 1);
        p.open(3, 5);
        p.open(4, 5);
        p.open(5, 5);
        p.open(3, 2);
        p.open(3, 3);
        p.open(3, 4);
        assertTrue(p.percolates());
    }

}
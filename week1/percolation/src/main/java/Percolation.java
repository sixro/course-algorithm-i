import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final int[] cells;
    private final WeightedQuickUnionUF uf;
    private final int topVirtualNode;
    private final int bottomVirtualNode;
    private int numberOfOpenSites;

    /**
     * Creates n-by-n grid, with all sites initially blocked
     */
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n has to be major than 0");
        this.n = n;
        int max = n * n;
        this.cells = new int[max];
        this.numberOfOpenSites = 0;

        this.topVirtualNode = max;
        this.bottomVirtualNode = max +1;
        this.uf = new WeightedQuickUnionUF(max +2);
    }

    /**
     * Opens the site (row, col) if it is not open already.
     *
     * @param row the row
     * @param col the column
     */
    public void open(int row, int col) {
        int i = xyTo1D(row, col);
        if (cells[i] == 1)
            return;

        numberOfOpenSites++;
        cells[i] = 1;

        // above-below
        int iAbove = i -n;
        int iBelow = i +n;
        if (row == 1) {
            uf.union(i, topVirtualNode);
        } else if (isOpen(iAbove)) {
            uf.union(iAbove, i);
        }
        if (row == n) {
            uf.union(i, bottomVirtualNode);
        } else if (isOpen(iBelow)) {
            uf.union(iBelow, i);
        }

        // left - right
        if (col > 1 && isOpen(i -1)) {
            uf.union(i -1, i);
        }
        if (col < n && isOpen(i +1)) {
            uf.union(i +1, i);
        }
    }

    /**
     * Returns true if the site at specified row/col is open.
     *
     * @param row the row
     * @param col the column
     * @return true if the site at specified row/col is open, otherwise false
     *
     * @see #isFull(int, int)
     */
    public boolean isOpen(int row, int col) {
        return isOpen(xyTo1D(row, col));
    }

    private boolean isOpen(int i) {
        return cells[i] == 1;
    }

    /**
     * Returns true if the site at specified row/col is full.
     *
     * @param row the row
     * @param col the column
     * @return true if the site at specified row/col is full, otherwise false
     *
     * @see #isOpen(int, int)
     */
    public boolean isFull(int row, int col) {
        return !isOpen(row, col);
    }

    /**
     * Returns the number of open sites.
     *
     * @return the number of open sites
     */
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    /**
     * Returns true if the grid percolates.
     *
     * @return true if the grid percolates, otherwise false
     */
    public boolean percolates() {
        return uf.find(topVirtualNode) == uf.find(bottomVirtualNode);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 1);
        if (! p.percolates())
            throw new IllegalStateException("Should percolate");
    }

    private int xyTo1D(int row, int col) {
        validate(row, col);
        return (row - 1) * n + col - 1;
    }

    private void validate(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) {
            String tpl = "expected row/col between 0 and N (got %d, %d)";
            throw new IllegalArgumentException(String.format(tpl, row, col));
        }
    }

}

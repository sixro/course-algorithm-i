public class Percolation {

    private final int n;
    private final int[] cells;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n has to be major than 0");
        this.n = n;
        this.cells = new int[n * n];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int i = xyTo1D(row, col);
        cells[i] = 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int i = xyTo1D(row, col);
        return cells[i] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return !isOpen(row, col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return -1;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }

    // Extracted method with the suggested name in F.A.Q.
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

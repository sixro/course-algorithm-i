import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int n;
    private final int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.n = n;
        this.trials = trials;

        this.run();
    }

    // sample mean of percolation threshold
    public double mean() {
        return -1d;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return -1d;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return -1d;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return -1d;
    }

    // test client (see below)
    public static void main(String[] args) {

    }

    private void run() {
        // TODO trials
        Percolation percolation = new Percolation(n);
        int max = n * n;
        int i = 0;
        while (! percolation.percolates()) {
            i++;

            int row = StdRandom.uniform(n) +1;
            int col = StdRandom.uniform(n) +1;
            System.out.println(row + ":" + col);
            percolation.open(row, col);
        }

        double p = ((double) (i)) / max;

        System.out.println(p);
    }

}

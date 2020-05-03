import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int n;
    private final int trials;
    private double[] xt;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.n = n;
        this.trials = trials;

        this.run();
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(xt);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(xt);
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
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats pstats = new PercolationStats(n, trials);
        StdOut.printf("mean                    = %s\n",
            Double.toString(pstats.mean()));
        StdOut.printf("stddev                  = %s\n",
            Double.toString(pstats.stddev()));
        StdOut.printf("95%% confidence interval = [ %s, %s ]\n",
            Double.toString(pstats.confidenceLo()),
            Double.toString(pstats.confidenceHi()));
    }

    private void run() {
        int max = n * n;
        xt = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int x = 0;
            while (! percolation.percolates()) {
                x++;

                int row = StdRandom.uniform(n) +1;
                int col = StdRandom.uniform(n) +1;
                //System.out.println(row + ":" + col);
                percolation.open(row, col);
            }

            xt[i] = ((double) (x)) / max;
        }
    }

}

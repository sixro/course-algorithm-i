import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96d;

    private final int n;
    private final int trials;
    private double[] xt;

    public PercolationStats(int n, int trials) {
        if (n <= 0)
            throw new IllegalArgumentException("n has to be major than 0");
        if (trials <= 0)
            throw new IllegalArgumentException("trials has to be major than 0");
        this.n = n;
        this.trials = trials;

        this.run();
    }

    public double mean() {
        return StdStats.mean(xt);
    }

    public double stddev() {
        return StdStats.stddev(xt);
    }

    public double confidenceLo() {
        return mean() - (stddev() * CONFIDENCE_95) / Math.sqrt(trials);
    }

    public double confidenceHi() {
        return mean() + (stddev() * CONFIDENCE_95) / Math.sqrt(trials);
    }

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
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) +1;
                int col = StdRandom.uniform(n) +1;
                percolation.open(row, col);
            }

            int os = percolation.numberOfOpenSites();
            xt[i] = ((double) os) / max;
        }
    }

}

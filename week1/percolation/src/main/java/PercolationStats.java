import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96d;

    private final double mean;
    private final double stddev;
    private final double conflo;
    private final double confhi;

    public PercolationStats(int n, int trials) {
        if (n <= 0)
            throw new IllegalArgumentException("n has to be major than 0");
        if (trials <= 0)
            throw new IllegalArgumentException("trials has to be major than 0");

        int max = n * n;
        double[] xt = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) +1;
                int col = StdRandom.uniform(n) +1;
                if (! percolation.isOpen(row, col))
                    percolation.open(row, col);
            }

            int os = percolation.numberOfOpenSites();
            xt[i] = ((double) os) / max;
        }

        this.mean = StdStats.mean(xt);
        this.stddev = StdStats.stddev(xt);
        double m = stddev * CONFIDENCE_95 / Math.sqrt(trials);
        this.conflo = mean - m;
        this.confhi = mean + m;
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return conflo;
    }

    public double confidenceHi() {
        return confhi;
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

}

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationStatsTest {

    @Test public void run() {
        PercolationStats pstats = new PercolationStats(5, 1);
        System.out.println(pstats.mean());
    }

    @Test
    //@Ignore
    public void main() {
        PercolationStats.main(new String[]{ "200", "100" });
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_n_minor_than_0() {
        new PercolationStats(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_n_equals_to_0() {
        new PercolationStats(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_trials_minor_than_0() {
        new PercolationStats(2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ctor_with_trials_equals_to_0() {
        new PercolationStats(2, 0);
    }

}
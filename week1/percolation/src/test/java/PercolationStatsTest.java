import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationStatsTest {

    @Test public void run() {
        PercolationStats pstats = new PercolationStats(5, 1);
        System.out.println(pstats.mean());
    }

    // TODO ctor n <=0
    // TODO trials <= 0
}
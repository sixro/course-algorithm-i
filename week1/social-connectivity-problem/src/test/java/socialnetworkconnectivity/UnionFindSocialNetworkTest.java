package socialnetworkconnectivity;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class UnionFindSocialNetworkTest {

    private final UnionFindSocialNetwork sn = new UnionFindSocialNetwork();

    @Test public void test_1000_members() throws IOException {
        InputStreamReader in = new InputStreamReader(
            new GZIPInputStream(classpath("/input_1000_450000_250000.txt.gz")));
        long timestamp = sn.allFriendsTimestamp(new ReaderFriendships(in));
        System.out.println(timestamp);
        Assert.assertNotEquals(-1, timestamp);
    }

    private InputStream classpath(String s) {
        return UnionFindSocialNetworkTest.class.getResourceAsStream(s);
    }

    @Test public void test_2000_members() throws IOException {
        InputStreamReader in = new InputStreamReader(
            new GZIPInputStream(classpath("/input_2000_1800000_750000.txt.gz")));
        long timestamp = sn.allFriendsTimestamp(new ReaderFriendships(in));
        System.out.println(timestamp);
        Assert.assertNotEquals(-1, timestamp);
    }

}
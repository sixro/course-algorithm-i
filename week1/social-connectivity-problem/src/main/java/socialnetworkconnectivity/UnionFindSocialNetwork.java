package socialnetworkconnectivity;

import edu.princeton.cs.algs4.UF;

public class UnionFindSocialNetwork implements SocialNetwork {

    /**
     * The basic idea is to have a virtual member to which we'll connect
     * all friends.
     * Additionally we have a counter (remaining) of members not yet connected
     * to our virtual member.
     * When we process each row, we call the union only when needed and we
     * take advantage of this action to decrease also the remaining counter
     * and preserve the current timestamp as the last one to be returned
     *
     * @return the timestamp at which all members are connected
     */
    @Override
    public long allFriendsTimestamp(Friendships friendships) {
        long start = System.currentTimeMillis();
        int N = friendships.candidates();
        System.out.println("N = " + N);

        int virtualFriend = N;
        int remaining = N;
        UF uf = new UF(N +1);

        int iterations = 0;
        long timestamp = -1;
        for (Friendship fs: friendships) {
            if (remaining == 0)
                break;

            iterations++;
            int f1id = fs.friend1();
            int f2id = fs.friend2();
            if (uf.find(f1id) != uf.find(virtualFriend)) {
                uf.union(f1id, virtualFriend);
                timestamp = fs.timestamp();
                remaining--;
            }
            if (uf.find(f2id) != uf.find(virtualFriend)) {
                uf.union(f2id, virtualFriend);
                timestamp = fs.timestamp();
                remaining--;
            }
        }

        System.out.println("Returning " + timestamp + " after " + iterations + " iterations and " + (System.currentTimeMillis() - start) + "ms");
        return timestamp;
    }

}

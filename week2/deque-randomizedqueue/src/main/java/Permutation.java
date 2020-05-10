import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        for (int i = 0; i < k; k++)
            queue.enqueue(StdIn.readString());

        for (String each: queue) {
            StdOut.println(each);
        }
    }

}

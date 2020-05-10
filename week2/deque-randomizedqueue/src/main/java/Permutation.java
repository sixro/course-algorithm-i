import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        try {
            for (int i = 0; i < k; i++) {
                String s = StdIn.readString();
                //System.err.println("Read: " + s);
                queue.enqueue(s);
            }
        } catch (NoSuchElementException e) {
        }

        for (String each: queue) {
            StdOut.println(each);
        }
    }

}

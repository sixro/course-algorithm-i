import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String[] texts = StdIn.readAllStrings();
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        for (String text: texts)
            queue.enqueue(text);

        int i = 0;
        for (String each: queue) {
            if (i++ >= k)
                break;
            StdOut.println(each);
        }

    }

}

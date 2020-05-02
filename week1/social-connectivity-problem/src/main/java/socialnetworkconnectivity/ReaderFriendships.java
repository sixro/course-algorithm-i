package socialnetworkconnectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReaderFriendships implements Friendships {

    private final Reader reader;

    public ReaderFriendships(Reader reader) {
        this.reader = reader;
    }

    @Override
    public int candidates() {
        try {
            BufferedReader br = new BufferedReader(reader);
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read the number of " +
                "candidates", e);
        }
    }

    @Override
    public Iterator<Friendship> iterator() {
        return new It(reader);
    }

    public static class It implements java.util.Iterator<Friendship> {

        private final BufferedReader bufferedReader;
        private String line;

        public It(Reader reader) {
            this(new BufferedReader(reader));
        }

        public It(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
            this.line = null;

            skip1stLine();
        }

        private void skip1stLine() {
            try {
                this.bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean hasNext() {
            try {
                line = bufferedReader.readLine();
                if (line == null) {
                    close();
                    return false;
                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException("Unable to read next line", e);
            }
        }

        @Override
        public Friendship next() {
            try {
                if (line == null) {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        close();
                        throw new NoSuchElementException();
                    }
                }
                return new TextFriendship(line);
            } catch (IOException e) {
                throw new RuntimeException("Unable to read next line", e);
            } finally {
                line = null;
            }
        }

        private void close() {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

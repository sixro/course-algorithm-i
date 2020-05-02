package socialnetworkconnectivity;

import java.util.Arrays;

public class TextFriendship implements Friendship {

    private final String[] texts;

    public TextFriendship(String text) {
        this(text.split(" "));
    }

    public TextFriendship(String[] texts) {
        this.texts = Arrays.copyOf(texts, 3);
    }

    @Override
    public long timestamp() {
        return Long.parseLong(texts[0]);
    }

    @Override
    public int friend1() {
        return Integer.parseInt(texts[1]);
    }

    @Override
    public int friend2() {
        return Integer.parseInt(texts[2]);
    }

    @Override
    public String toString() {
        return "TextFriendship{" + "texts=" + Arrays.toString(texts) + '}';
    }
}

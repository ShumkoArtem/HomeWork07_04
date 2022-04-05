package HomeWork07_04;

import java.util.Comparator;
import java.util.Objects;

public class Count{
    private String word;
    private int count;

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public Count(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return "{" + "Word = " + word + ", count = " + count + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count && Objects.equals(word, count1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }
}

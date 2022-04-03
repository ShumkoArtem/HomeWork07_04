package HomeWork07_04;

import java.util.Objects;

public class Count implements Comparable{
    private String word;
    private int count;

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return Objects.equals(word, count.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    public Count(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}

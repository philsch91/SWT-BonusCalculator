package at.fhcampuswien.swtbonuspayment;

import java.util.Objects;

public class Bonus extends Object {
    Double value;

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bonus)) return false;
        Bonus bonus = (Bonus) o;
        return Objects.equals(value, bonus.value);
    }
}
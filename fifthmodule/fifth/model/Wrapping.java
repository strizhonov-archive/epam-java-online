package fifth.model;

import java.util.Objects;

public class Wrapping {

    private String color;
    private boolean isTransparent;

    public Wrapping(String color, boolean isTransparent) {
        this.color = color;
        this.isTransparent = isTransparent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(color.toLowerCase());
        if (isTransparent) {
            sb.append(" transparent");
        } else {
            sb.append(" non-transparent");
        }
        sb.append(" wrapping.");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Wrapping)) {
            return false;
        }
        Wrapping wrapping = (Wrapping) o;
        return Objects.equals(color, wrapping.color)
                && Objects.equals(isTransparent, wrapping.isTransparent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, isTransparent);
    }
}

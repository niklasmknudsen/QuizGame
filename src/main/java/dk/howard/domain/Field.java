package dk.howard.domain;

public class Field {

    private final String field;

    public Field(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Field{" +
                "field='" + field + '\'' +
                '}';
    }
}

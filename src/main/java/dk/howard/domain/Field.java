package dk.howard.domain;

import java.io.Serializable;

public class Field implements Serializable {

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

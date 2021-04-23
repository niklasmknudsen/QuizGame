package dk.howard.domain;

import java.io.Serializable;

public class Description implements Serializable {

    private final String description;

    public Description(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Description{" +
                "description='" + description + '\'' +
                '}';
    }
}

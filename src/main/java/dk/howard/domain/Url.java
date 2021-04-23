package dk.howard.domain;

import java.io.Serializable;

public class Url implements Serializable {

    private final String url;

    public Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                '}';
    }
}

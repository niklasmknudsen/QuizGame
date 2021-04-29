package dk.QuizGame;

import dk.QuizGame.build.BuildObjects;
import io.helidon.microprofile.server.Server;

public class Main {
    public static final String DEPLOYMENT_NAME = "mini-helidon";

    private Main() { }

    public static void main(final String[] args) {
        // Set system properties
        System.setProperty("LOG4J2_DEPLOYMENT_NAME", DEPLOYMENT_NAME);

        BuildObjects bo = new BuildObjects();
        bo.seed();

        // start the server
        createServer().start();
    }

    public static Server createServer() {
        // Server will automatically pick up configuration from
        // microprofile-config.properties
        return Server.create();
    }
}

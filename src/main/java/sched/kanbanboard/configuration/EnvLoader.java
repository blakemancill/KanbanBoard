package sched.kanbanboard.configuration;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    public static void loadDotenv() {
        Dotenv dotenv = Dotenv.configure()
                .directory("./")
                .ignoreIfMissing()
                .load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }

    private EnvLoader() {}
}

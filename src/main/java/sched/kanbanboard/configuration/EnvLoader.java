package sched.kanbanboard.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvLoader {
    public static void loadDotenv() {
        /*
        Loads environment variables from the .env file in project root. Allows project to share database
        information with application.yaml and docker-compose.yaml
         */
        Dotenv dotenv = Dotenv.configure()
                .directory("./")
                .ignoreIfMissing()
                .load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    }
}

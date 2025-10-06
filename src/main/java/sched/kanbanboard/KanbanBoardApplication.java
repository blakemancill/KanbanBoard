package sched.kanbanboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sched.kanbanboard.configuration.EnvLoader;

@SpringBootApplication
public class KanbanBoardApplication {

    private KanbanBoardApplication() {}

    static void main(String[] args) {
        EnvLoader.loadDotenv();
        SpringApplication.run(KanbanBoardApplication.class, args);
    }
}

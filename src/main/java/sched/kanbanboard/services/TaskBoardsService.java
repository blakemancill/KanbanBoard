package sched.kanbanboard.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sched.kanbanboard.entities.TaskBoards;
import sched.kanbanboard.exceptions.TaskBoardAlreadyExistsException;
import sched.kanbanboard.repositories.TaskBoardsRepository;

import java.time.Instant;
import java.util.List;

@Service
@Slf4j
public class TaskBoardsService {

    private final TaskBoardsRepository taskBoardsRepo;

    public TaskBoardsService(TaskBoardsRepository taskBoardsRepo) {
        this.taskBoardsRepo = taskBoardsRepo;
    }

    public List<TaskBoards> getAllTaskBoards() {
        return taskBoardsRepo.findAll();
    }

    public TaskBoards createTaskBoard(TaskBoards taskBoard) {
        log.debug("Checking if task board with id '{}' already exists", taskBoard.getId());
        if (taskBoardsRepo.existsByName(taskBoard.getName())) {
            log.warn("Task board with name '{}' already exists", taskBoard.getName());
            throw new TaskBoardAlreadyExistsException(taskBoard.getName());
        }

        taskBoard.setCreatedAt(Instant.now());
        TaskBoards saved = taskBoardsRepo.save(taskBoard);
        log.info("Saved task board with id {}", saved.getId());
        return saved;
    }
}

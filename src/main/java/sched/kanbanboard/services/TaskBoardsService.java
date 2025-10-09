package sched.kanbanboard.services;

import org.springframework.stereotype.Service;
import sched.kanbanboard.entities.TaskBoards;
import sched.kanbanboard.exceptions.TaskBoardAlreadyExistsException;
import sched.kanbanboard.repositories.TaskBoardsRepository;

import java.time.Instant;
import java.util.List;

@Service
public class TaskBoardsService {

    private final TaskBoardsRepository taskBoardsRepo;

    public TaskBoardsService(TaskBoardsRepository taskBoardsRepo) {
        this.taskBoardsRepo = taskBoardsRepo;
    }

    public List<TaskBoards> getAllTaskBoards() {
        return taskBoardsRepo.findAll();
    }

    public TaskBoards createTaskBoard(TaskBoards taskBoard) {
        if(taskBoardsRepo.existsByName(taskBoard.getName())) {
            throw new TaskBoardAlreadyExistsException(taskBoard.getName());
        }
        taskBoard.setCreatedAt(Instant.now());
        return taskBoardsRepo.save(taskBoard);
    }
}

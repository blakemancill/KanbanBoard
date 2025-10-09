package sched.kanbanboard.services;

import org.springframework.stereotype.Service;
import sched.kanbanboard.entities.TaskBoards;
import sched.kanbanboard.repositories.TaskBoardsRepository;

import java.util.List;

@Service
public class TaskBoardsService {

    private TaskBoardsRepository taskBoardsRepo;

    public TaskBoardsService(TaskBoardsRepository taskBoardsRepo) {
        this.taskBoardsRepo = taskBoardsRepo;
    }

    public List<TaskBoards> getAllTaskBoards() {
        return taskBoardsRepo.findAll();
    }
}

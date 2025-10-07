package sched.kanbanboard.features.boards;

import org.springframework.stereotype.Service;

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

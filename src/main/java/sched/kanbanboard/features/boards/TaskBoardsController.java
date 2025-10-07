package sched.kanbanboard.features.boards;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TaskBoardsController {

    private TaskBoardsService taskBoardsService;

    public TaskBoardsController(TaskBoardsService taskBoardsService) {
        this.taskBoardsService = taskBoardsService;
    }

    @GetMapping("/taskboard")
    public List<TaskBoards> getTaskBoards(){
        return taskBoardsService.getAllTaskBoards();
    }
}

package sched.kanbanboard.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sched.kanbanboard.dtos.TaskBoardDTO;
import sched.kanbanboard.entities.TaskBoards;
import sched.kanbanboard.services.TaskBoardsService;

import java.util.List;

@RestController()
@RequestMapping("/taskboard")
public class TaskBoardsController {

    private final TaskBoardsService taskBoardsService;

    public TaskBoardsController(TaskBoardsService taskBoardsService) {
        this.taskBoardsService = taskBoardsService;
    }

    @GetMapping()
    public List<TaskBoards> getTaskBoards(){
        return taskBoardsService.getAllTaskBoards();
    }

    @PostMapping()
    public ResponseEntity<TaskBoards> createTaskBoard(@Valid @RequestBody TaskBoardDTO dto){
        TaskBoards taskBoard = new TaskBoards();
        taskBoard.setName(dto.getName());
        TaskBoards createdBoard = taskBoardsService.createTaskBoard(taskBoard);
        return new  ResponseEntity<>(createdBoard, HttpStatus.CREATED);
    }
}

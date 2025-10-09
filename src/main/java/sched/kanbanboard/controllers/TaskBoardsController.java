package sched.kanbanboard.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sched.kanbanboard.dtos.TaskBoardDTO;
import sched.kanbanboard.entities.TaskBoards;
import sched.kanbanboard.services.TaskBoardsService;

import java.util.List;

@RestController()
@RequestMapping("/taskboard")
@Slf4j
public class TaskBoardsController {

    private final TaskBoardsService taskBoardsService;

    public TaskBoardsController(TaskBoardsService taskBoardsService) {
        this.taskBoardsService = taskBoardsService;
    }

    @GetMapping()
    public List<TaskBoards> getTaskBoards() {
        log.info("Fetching all task boards");
        return taskBoardsService.getAllTaskBoards();
    }

    @PostMapping()
    public ResponseEntity<TaskBoards> createTaskBoard(@Valid @RequestBody TaskBoardDTO dto) {
        log.info("Creating task board with name {}", dto.getName());
        TaskBoards taskBoard = new TaskBoards();
        taskBoard.setName(dto.getName());

        TaskBoards createdBoard = taskBoardsService.createTaskBoard(taskBoard);
        log.info("Created task board with id {}", createdBoard.getId());

        return new  ResponseEntity<>(createdBoard, HttpStatus.CREATED);
    }
}

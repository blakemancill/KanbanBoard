package sched.kanbanboard.exceptions;

public class TaskBoardAlreadyExistsException extends RuntimeException {
    public TaskBoardAlreadyExistsException(String message) {
        super("Task board with name " + message + " already exists");
    }
}

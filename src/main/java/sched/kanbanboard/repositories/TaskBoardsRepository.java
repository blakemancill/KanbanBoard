package sched.kanbanboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sched.kanbanboard.entities.TaskBoards;

public interface TaskBoardsRepository extends JpaRepository<TaskBoards, Integer> {
}

package sched.kanbanboard.features.boards;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskBoardsRepository extends JpaRepository<TaskBoards, Integer> {
}

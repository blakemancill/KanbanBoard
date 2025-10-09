package sched.kanbanboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sched.kanbanboard.entities.TaskItemHistory;

public interface TaskItemHistoryRepository extends JpaRepository<TaskItemHistory, Integer> {
}

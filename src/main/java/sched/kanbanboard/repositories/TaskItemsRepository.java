package sched.kanbanboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sched.kanbanboard.entities.TaskItems;

public interface TaskItemsRepository extends JpaRepository<TaskItems, Integer> {
}

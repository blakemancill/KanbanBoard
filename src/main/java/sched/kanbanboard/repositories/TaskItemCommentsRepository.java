package sched.kanbanboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sched.kanbanboard.entities.TaskItemComments;

public interface TaskItemCommentsRepository extends JpaRepository<TaskItemComments, Integer> {
}

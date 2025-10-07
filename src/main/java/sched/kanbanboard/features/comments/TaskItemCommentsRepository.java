package sched.kanbanboard.features.comments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemCommentsRepository extends JpaRepository<TaskItemComments, Integer> {
}

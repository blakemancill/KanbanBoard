package sched.kanbanboard.features.history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemHistoryRepository extends JpaRepository<TaskItemHistory, Integer> {
}

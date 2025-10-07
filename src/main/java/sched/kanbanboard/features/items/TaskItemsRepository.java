package sched.kanbanboard.features.items;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemsRepository extends JpaRepository<TaskItems, Integer> {
}

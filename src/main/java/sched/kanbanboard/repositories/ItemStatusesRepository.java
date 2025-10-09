package sched.kanbanboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sched.kanbanboard.entities.ItemStatuses;

public interface ItemStatusesRepository extends JpaRepository<ItemStatuses, Integer> {
}

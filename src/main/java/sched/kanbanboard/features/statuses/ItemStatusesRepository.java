package sched.kanbanboard.features.statuses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemStatusesRepository extends JpaRepository<ItemStatuses, Integer> {
}

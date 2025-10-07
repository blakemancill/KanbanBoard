package sched.kanbanboard.features.history;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import sched.kanbanboard.features.comments.TaskItemComments;
import sched.kanbanboard.features.items.TaskItems;
import sched.kanbanboard.features.statuses.ItemStatuses;

import java.time.Instant;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskItemHistory {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_item_id", nullable = false)
    private TaskItems taskItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_status_id")
    private ItemStatuses previousStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_status_id")
    private ItemStatuses newStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private TaskItemComments comment;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "changed_at")
    private Instant changedAt;

}

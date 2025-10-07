package sched.kanbanboard.features.history;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskItemHistory {

    @NotNull
    @ColumnDefault("nextval('task_item_history_id_seq')")
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @NotNull
    @Column(name = "task_item_id", nullable = false)
    private Integer taskItemId;

    @Column(name = "previous_status_id")
    private Integer previousStatusId;

    @Column(name = "new_status_id")
    private Integer newStatusId;

    @Column(name = "comment_id")
    private Integer commentId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "changed_at")
    private Instant changedAt;

}

package sched.kanbanboard.features.comments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskItemComments {

    @NotNull
    @ColumnDefault("nextval('task_item_comments_id_seq')")
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @NotNull
    @Column(name = "task_item_id", nullable = false)
    private Integer taskItemId;

    @NotNull
    @Column(name = "comment", nullable = false, length = Integer.MAX_VALUE)
    private String comment;

}

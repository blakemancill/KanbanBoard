package sched.kanbanboard.features.comments;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sched.kanbanboard.features.items.TaskItems;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskItemComments {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_item_id", nullable = false)
    private TaskItems taskItem;

    @NotNull
    @Column(name = "comment", nullable = false)
    private String comment;

}

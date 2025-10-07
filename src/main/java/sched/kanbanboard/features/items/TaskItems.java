package sched.kanbanboard.features.items;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sched.kanbanboard.features.boards.TaskBoards;
import sched.kanbanboard.features.comments.TaskItemComments;
import sched.kanbanboard.features.history.TaskItemHistory;
import sched.kanbanboard.features.statuses.ItemStatuses;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskItems {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private TaskBoards board;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private ItemStatuses status;

    @OneToMany(mappedBy = "taskItem")
    private List<TaskItemComments> comments;

    @OneToMany(mappedBy = "taskItem")
    private List<TaskItemHistory> history;
}

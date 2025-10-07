package sched.kanbanboard.features.statuses;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import sched.kanbanboard.features.history.TaskItemHistory;
import sched.kanbanboard.features.items.TaskItems;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemStatuses {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "status_name", nullable = false, length = 50)
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List<TaskItems> items;

    @OneToMany(mappedBy = "previousStatus")
    private List<TaskItemHistory> previousHistories;

    @OneToMany(mappedBy = "newStatus")
    private List<TaskItemHistory> newHistories;
}

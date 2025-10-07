package sched.kanbanboard.features.items;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskItems {

    @NotNull
    @ColumnDefault("nextval('task_items_id_seq')")
    @Column(name = "id", nullable = false)
    @Id
    private Integer id;

    @NotNull
    @Column(name = "board_id", nullable = false)
    private Integer boardId;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @Column(name = "status_id", nullable = false)
    private Integer statusId;

}

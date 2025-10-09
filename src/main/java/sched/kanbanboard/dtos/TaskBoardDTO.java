package sched.kanbanboard.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TaskBoardDTO {

    @NotNull
    @Size(max = 255)
    private String name;
}

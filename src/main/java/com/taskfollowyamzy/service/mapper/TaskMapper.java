package com.taskfollowyamzy.service.mapper;

import com.taskfollowyamzy.domain.Task;
import com.taskfollowyamzy.service.dto.TaskDashboardDTO;
import java.util.List;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Task} and its DTO {@link TaskDashboardDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TaskMapper {
    @Mapping(
        target = "shortDescription",
        expression = "java(task.getDescription() == null ? null : (task.getDescription().length() > 100 ? task.getDescription().substring(0, 100) + \"...\" : task.getDescription()))"
    )
    @Mapping(target = "status", expression = "java(task.getStatus() != null ? task.getStatus().name() : null)")
    TaskDashboardDTO toDashboardDTO(Task task);

    List<TaskDashboardDTO> toDashboardDTOs(List<Task> tasks);
}
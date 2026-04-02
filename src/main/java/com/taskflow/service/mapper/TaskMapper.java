package com.taskflow.service.mapper;

import com.taskflow.domain.Member;
import com.taskflow.domain.Project;
import com.taskflow.domain.Status;
import com.taskflow.domain.Task;
import com.taskflow.service.dto.MemberDTO;
import com.taskflow.service.dto.ProjectDTO;
import com.taskflow.service.dto.StatusDTO;
import com.taskflow.service.dto.TaskDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Task} and its DTO {@link TaskDTO}.
 */
@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {
    @Mapping(target = "project", source = "project", qualifiedByName = "projectId")
    @Mapping(target = "assignedTo", source = "assignedTo", qualifiedByName = "memberId")
    @Mapping(target = "status", source = "status", qualifiedByName = "statusId")
    TaskDTO toDto(Task s);

    @Named("projectId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProjectDTO toDtoProjectId(Project project);

    @Named("memberId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MemberDTO toDtoMemberId(Member member);

    @Named("statusId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StatusDTO toDtoStatusId(Status status);
}

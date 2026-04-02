package com.taskflow.service.mapper;

import com.taskflow.domain.Member;
import com.taskflow.domain.Project;
import com.taskflow.service.dto.MemberDTO;
import com.taskflow.service.dto.ProjectDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Member} and its DTO {@link MemberDTO}.
 */
@Mapper(componentModel = "spring")
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {
    @Mapping(target = "projects", source = "projects", qualifiedByName = "projectIdSet")
    MemberDTO toDto(Member s);

    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "removeProjects", ignore = true)
    Member toEntity(MemberDTO memberDTO);

    @Named("projectId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProjectDTO toDtoProjectId(Project project);

    @Named("projectIdSet")
    default Set<ProjectDTO> toDtoProjectIdSet(Set<Project> project) {
        return project.stream().map(this::toDtoProjectId).collect(Collectors.toSet());
    }
}

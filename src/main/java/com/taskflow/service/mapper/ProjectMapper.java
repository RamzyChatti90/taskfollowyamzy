package com.taskflow.service.mapper;

import com.taskflow.domain.Member;
import com.taskflow.domain.Project;
import com.taskflow.service.dto.MemberDTO;
import com.taskflow.service.dto.ProjectDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Project} and its DTO {@link ProjectDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {
    @Mapping(target = "members", source = "members", qualifiedByName = "memberIdSet")
    ProjectDTO toDto(Project s);

    @Mapping(target = "removeMembers", ignore = true)
    Project toEntity(ProjectDTO projectDTO);

    @Named("memberId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MemberDTO toDtoMemberId(Member member);

    @Named("memberIdSet")
    default Set<MemberDTO> toDtoMemberIdSet(Set<Member> member) {
        return member.stream().map(this::toDtoMemberId).collect(Collectors.toSet());
    }
}

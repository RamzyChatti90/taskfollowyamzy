package com.taskflow.domain;

import static com.taskflow.domain.MemberTestSamples.*;
import static com.taskflow.domain.ProjectTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.taskflow.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ProjectTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Project.class);
        Project project1 = getProjectSample1();
        Project project2 = new Project();
        assertThat(project1).isNotEqualTo(project2);

        project2.setId(project1.getId());
        assertThat(project1).isEqualTo(project2);

        project2 = getProjectSample2();
        assertThat(project1).isNotEqualTo(project2);
    }

    @Test
    void membersTest() {
        Project project = getProjectRandomSampleGenerator();
        Member memberBack = getMemberRandomSampleGenerator();

        project.addMembers(memberBack);
        assertThat(project.getMembers()).containsOnly(memberBack);

        project.removeMembers(memberBack);
        assertThat(project.getMembers()).doesNotContain(memberBack);

        project.members(new HashSet<>(Set.of(memberBack)));
        assertThat(project.getMembers()).containsOnly(memberBack);

        project.setMembers(new HashSet<>());
        assertThat(project.getMembers()).doesNotContain(memberBack);
    }
}

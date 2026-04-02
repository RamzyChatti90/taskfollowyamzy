package com.taskflow.domain;

import static com.taskflow.domain.MemberTestSamples.*;
import static com.taskflow.domain.ProjectTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.taskflow.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Member.class);
        Member member1 = getMemberSample1();
        Member member2 = new Member();
        assertThat(member1).isNotEqualTo(member2);

        member2.setId(member1.getId());
        assertThat(member1).isEqualTo(member2);

        member2 = getMemberSample2();
        assertThat(member1).isNotEqualTo(member2);
    }

    @Test
    void projectsTest() {
        Member member = getMemberRandomSampleGenerator();
        Project projectBack = getProjectRandomSampleGenerator();

        member.addProjects(projectBack);
        assertThat(member.getProjects()).containsOnly(projectBack);
        assertThat(projectBack.getMembers()).containsOnly(member);

        member.removeProjects(projectBack);
        assertThat(member.getProjects()).doesNotContain(projectBack);
        assertThat(projectBack.getMembers()).doesNotContain(member);

        member.projects(new HashSet<>(Set.of(projectBack)));
        assertThat(member.getProjects()).containsOnly(projectBack);
        assertThat(projectBack.getMembers()).containsOnly(member);

        member.setProjects(new HashSet<>());
        assertThat(member.getProjects()).doesNotContain(projectBack);
        assertThat(projectBack.getMembers()).doesNotContain(member);
    }
}

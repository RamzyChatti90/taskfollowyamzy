package com.taskflow.domain;

import static com.taskflow.domain.MemberTestSamples.*;
import static com.taskflow.domain.ProjectTestSamples.*;
import static com.taskflow.domain.StatusTestSamples.*;
import static com.taskflow.domain.TaskTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.taskflow.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Task.class);
        Task task1 = getTaskSample1();
        Task task2 = new Task();
        assertThat(task1).isNotEqualTo(task2);

        task2.setId(task1.getId());
        assertThat(task1).isEqualTo(task2);

        task2 = getTaskSample2();
        assertThat(task1).isNotEqualTo(task2);
    }

    @Test
    void projectTest() {
        Task task = getTaskRandomSampleGenerator();
        Project projectBack = getProjectRandomSampleGenerator();

        task.setProject(projectBack);
        assertThat(task.getProject()).isEqualTo(projectBack);

        task.project(null);
        assertThat(task.getProject()).isNull();
    }

    @Test
    void assignedToTest() {
        Task task = getTaskRandomSampleGenerator();
        Member memberBack = getMemberRandomSampleGenerator();

        task.setAssignedTo(memberBack);
        assertThat(task.getAssignedTo()).isEqualTo(memberBack);

        task.assignedTo(null);
        assertThat(task.getAssignedTo()).isNull();
    }

    @Test
    void statusTest() {
        Task task = getTaskRandomSampleGenerator();
        Status statusBack = getStatusRandomSampleGenerator();

        task.setStatus(statusBack);
        assertThat(task.getStatus()).isEqualTo(statusBack);

        task.status(null);
        assertThat(task.getStatus()).isNull();
    }
}

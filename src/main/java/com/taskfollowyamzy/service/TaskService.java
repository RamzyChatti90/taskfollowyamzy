package com.taskfollowyamzy.repository;

import com.taskfollowyamzy.domain.Task;
import com.taskfollowyamzy.domain.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link Task} entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Finds all tasks assigned to a specific user.
     * Assumes the Task entity has a field named 'assignedUser' of type User.
     *
     * @param user The user to find tasks for.
     * @return A list of tasks assigned to the given user.
     */
    List<Task> findByAssignedUser(User user);
}
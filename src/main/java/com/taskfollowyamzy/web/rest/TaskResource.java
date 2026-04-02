package com.taskfollowyamzy.web.rest;

import com.taskfollowyamzy.service.TaskService;
import com.taskfollowyamzy.service.dto.TaskDashboardDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing {@link com.taskfollowyamzy.domain.Task}.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskResource {

    private final Logger log = LoggerFactory.getLogger(TaskResource.class);

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * {@code GET /my-tasks} : get all the tasks assigned to the current authenticated user.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tasks in body.
     */
    @GetMapping("/my-tasks")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<TaskDashboardDTO>> getMyTasks() {
        log.debug("REST request to get all Tasks for current user");
        List<TaskDashboardDTO> tasks = taskService.getTasksForCurrentUser();
        return ResponseEntity.ok().body(tasks);
    }
}
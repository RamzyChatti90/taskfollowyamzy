package com.taskfollowyamzy.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.taskfollowyamzy.domain.Task} entity.
 * Represents a simplified view for the task dashboard.
 */
public class TaskDashboardDTO implements Serializable {

    private Long id;
    private String title;
    private String shortDescription;
    private String status;

    public TaskDashboardDTO() {
        // Empty constructor needed for Jackson
    }

    public TaskDashboardDTO(Long id, String title, String shortDescription, String status) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskDashboardDTO)) {
            return false;
        }
        TaskDashboardDTO that = (TaskDashboardDTO) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "TaskDashboardDTO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", shortDescription='" + shortDescription + '\'' +
            ", status='" + status + '\'' +
            '}';
    }
}
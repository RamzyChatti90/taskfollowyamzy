import { Component, OnInit } from '@angular/core';
import { TaskService } from 'app/entities/task/service/task.service';
import { ITaskDashboardItem } from './task-dashboard-item.model';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  tasks: ITaskDashboardItem[] = [];
  isLoading = false;

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.loadTasksForCurrentUser();
  }

  loadTasksForCurrentUser(): void {
    this.isLoading = true;
    this.taskService.getTasksForCurrentUser().subscribe(
      (res: HttpResponse<ITaskDashboardItem[]>) => {
        this.isLoading = false;
        this.tasks = res.body ?? [];
      },
      () => {
        this.isLoading = false;
        // Handle error, e.g., display a toast notification
        console.error('Failed to load tasks for current user.');
      }
    );
  }
}
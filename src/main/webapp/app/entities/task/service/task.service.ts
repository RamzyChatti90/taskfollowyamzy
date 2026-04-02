import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { ITask } from '../task.model';
import { ITaskDashboardItem } from '../../../home/task-dashboard-item.model'; // New import for the dashboard item model

export type EntityResponseType = HttpResponse<ITask>;
export type EntityArrayResponseType = HttpResponse<ITask[]>;

@Injectable({ providedIn: 'root' })
export class TaskService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/tasks');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(task: ITask): Observable<EntityResponseType> {
    return this.http.post<ITask>(this.resourceUrl, task, { observe: 'response' });
  }

  update(task: ITask): Observable<EntityResponseType> {
    return this.http.put<ITask>(`${this.resourceUrl}/${this.getTaskIdentifier(task)}`, task, { observe: 'response' });
  }

  partialUpdate(task: ITask): Observable<EntityResponseType> {
    return this.http.patch<ITask>(`${this.resourceUrl}/${this.getTaskIdentifier(task)}`, task, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ITask>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = this.createRequestOption(req);
    return this.http.get<ITask[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  getTasksForCurrentUser(): Observable<ITaskDashboardItem[]> {
    return this.http.get<ITaskDashboardItem[]>(`${this.resourceUrl}/my-tasks`);
  }

  protected getTaskIdentifier(task: ITask): number | undefined {
    return task.id;
  }

  protected createRequestOption(req?: any): any {
    // This method needs to be implemented or imported from a common utility if it's not already in the service.
    // Assuming it's a standard JHipster utility method for query parameters.
    // For brevity, a basic implementation placeholder is shown.
    return req;
  }
}
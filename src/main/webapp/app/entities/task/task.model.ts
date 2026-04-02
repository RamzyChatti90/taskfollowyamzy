import dayjs from 'dayjs/esm';
import { IProject } from 'app/entities/project/project.model';
import { IMember } from 'app/entities/member/member.model';
import { IStatus } from 'app/entities/status/status.model';

export interface ITask {
  id: number;
  title?: string | null;
  description?: string | null;
  dueDate?: dayjs.Dayjs | null;
  priority?: number | null;
  completed?: boolean | null;
  project?: Pick<IProject, 'id'> | null;
  assignedTo?: Pick<IMember, 'id'> | null;
  status?: Pick<IStatus, 'id'> | null;
}

export type NewTask = Omit<ITask, 'id'> & { id: null };

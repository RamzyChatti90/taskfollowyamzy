import dayjs from 'dayjs/esm';
import { IMember } from 'app/entities/member/member.model';

export interface IProject {
  id: number;
  name?: string | null;
  description?: string | null;
  startDate?: dayjs.Dayjs | null;
  endDate?: dayjs.Dayjs | null;
  members?: Pick<IMember, 'id'>[] | null;
}

export type NewProject = Omit<IProject, 'id'> & { id: null };

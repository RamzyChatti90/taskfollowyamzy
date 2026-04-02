import { IProject } from 'app/entities/project/project.model';

export interface IMember {
  id: number;
  login?: string | null;
  firstName?: string | null;
  lastName?: string | null;
  email?: string | null;
  projects?: Pick<IProject, 'id'>[] | null;
}

export type NewMember = Omit<IMember, 'id'> & { id: null };

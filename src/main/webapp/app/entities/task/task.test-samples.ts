import dayjs from 'dayjs/esm';

import { ITask, NewTask } from './task.model';

export const sampleWithRequiredData: ITask = {
  id: 9181,
  title: 'or consequently',
};

export const sampleWithPartialData: ITask = {
  id: 11622,
  title: 'repeatedly',
  description: '../fake-data/blob/hipster.txt',
  completed: false,
};

export const sampleWithFullData: ITask = {
  id: 13396,
  title: 'where wherever',
  description: '../fake-data/blob/hipster.txt',
  dueDate: dayjs('2026-04-02'),
  priority: 7,
  completed: false,
};

export const sampleWithNewData: NewTask = {
  title: 'expostulate',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

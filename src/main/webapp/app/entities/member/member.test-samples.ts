import { IMember, NewMember } from './member.model';

export const sampleWithRequiredData: IMember = {
  id: 26797,
  login: undefined,
  email: ',r;-=0@,"Y.`z',
};

export const sampleWithPartialData: IMember = {
  id: 8524,
  login: 'ptc9',
  email: 'xf,,6I@OD\\.[LD',
};

export const sampleWithFullData: IMember = {
  id: 30531,
  login: 'DZXX',
  firstName: 'Danny',
  lastName: 'Johnson',
  email: 'r8OE@G`:.OJ!',
};

export const sampleWithNewData: NewMember = {
  login: 'fXXX',
  email: 'IyEX@`!52.2',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

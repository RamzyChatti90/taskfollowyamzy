import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'taskfollowyamzyApp.adminAuthority.home.title' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'project',
    data: { pageTitle: 'taskfollowyamzyApp.project.home.title' },
    loadChildren: () => import('./project/project.routes'),
  },
  {
    path: 'member',
    data: { pageTitle: 'taskfollowyamzyApp.member.home.title' },
    loadChildren: () => import('./member/member.routes'),
  },
  {
    path: 'status',
    data: { pageTitle: 'taskfollowyamzyApp.status.home.title' },
    loadChildren: () => import('./status/status.routes'),
  },
  {
    path: 'task',
    data: { pageTitle: 'taskfollowyamzyApp.task.home.title' },
    loadChildren: () => import('./task/task.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;

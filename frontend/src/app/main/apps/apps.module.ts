import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FuseSharedModule } from '@fuse/shared.module';

const routes = [
    {
        path        : 'dashboards/project',
        loadChildren: './dashboards/project/project.module#ProjectDashboardModule'
    },
    {
        path        : 'calendar',
        loadChildren: './calendar/calendar.module#CalendarModule'
    },
    {
        path        : 'todo',
        loadChildren: './todo/todo.module#TodoModule'
    },
    {
        path        : 'contacts',
        loadChildren: './contacts/contacts.module#ContactsModule'
    }
];

@NgModule({
    imports     : [
        RouterModule.forChild(routes),
        FuseSharedModule
    ]
})
export class AppsModule
{
}

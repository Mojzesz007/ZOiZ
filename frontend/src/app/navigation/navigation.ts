import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
    {
        id       : 'applications',
        title    : 'Applications',
        translate: 'NAV.APPLICATIONS',
        type     : 'group',
        icon     : 'apps',
        children : [
            {
                id       : 'dashboard',
                title    : 'Dashboard',
                translate: 'NAV.DASHBOARDS',
                type     : 'item',
                icon     : 'dashboard',
                url  : '/apps/dashboards/project'
            },
            {
                id       : 'calendar',
                title    : 'Calendar',
                translate: 'NAV.CALENDAR',
                type     : 'item',
                icon     : 'today',
                url      : '/apps/calendar'
            },
            {
                id       : 'contacts',
                title    : 'Contacts',
                translate: 'NAV.CONTACTS',
                type     : 'item',
                icon     : 'account_box',
                url      : '/apps/contacts'
            },
            {
                id       : 'to-do',
                title    : 'To-Do',
                translate: 'NAV.TODO',
                type     : 'item',
                icon     : 'check_box',
                url      : '/apps/todo',
                badge    : {
                    title: '3',
                    bg   : '#FF6F00',
                    fg   : '#FFFFFF'
                }
            }
        ]
    }
];

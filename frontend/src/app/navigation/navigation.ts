import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
    {
        id       : 'applications',
        subject    : 'Applications',
        translate: 'NAV.APPLICATIONS',
        type     : 'group',
        icon     : 'apps',
        children : [
            {
                id       : 'dashboard',
                subject    : 'Dashboard',
                translate: 'NAV.DASHBOARDS',
                type     : 'item',
                icon     : 'dashboard',
                url  : '/apps/dashboards/project'
            },
            // {
            //     id       : 'calendar',
            //     subject    : 'Calendar',
            //     translate: 'NAV.CALENDAR',
            //     type     : 'item',
            //     icon     : 'today',
            //     url      : '/apps/calendar'
            // },
            // {
            //     id       : 'contacts',
            //     subject    : 'Contacts',
            //     translate: 'NAV.CONTACTS',
            //     type     : 'item',
            //     icon     : 'account_box',
            //     url      : '/apps/contacts'
            // },
            {
                id       : 'to-do',
                subject    : 'To-Do',
                translate: 'NAV.TODO',
                type     : 'item',
                icon     : 'check_box',
                url      : '/apps/todo',
                badge    : {
                    subject: '3',
                    bg   : '#FF6F00',
                    fg   : '#FFFFFF'
                }
            }
        ]
    }
];

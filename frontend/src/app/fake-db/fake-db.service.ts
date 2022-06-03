import { InMemoryDbService } from 'angular-in-memory-web-api';

import { ProjectDashboardDb } from 'app/fake-db/dashboard-project';
import { CalendarFakeDb } from 'app/fake-db/calendar';
import { ContactsFakeDb } from 'app/fake-db/contacts';
import { TodoFakeDb } from 'app/fake-db/todo';
import { ProfileFakeDb } from 'app/fake-db/profile';
import { SearchFakeDb } from 'app/fake-db/search';
import { FaqFakeDb } from 'app/fake-db/faq';
import { IconsFakeDb } from 'app/fake-db/icons';
import { QuickPanelFakeDb } from 'app/fake-db/quick-panel';

export class FakeDbService implements InMemoryDbService
{
    createDb(): any
    {
        return {
            // Dashboards
            'project-dashboard-projects' : ProjectDashboardDb.projects,
            'project-dashboard-widgets'  : ProjectDashboardDb.widgets,

            // Calendar
            'calendar': CalendarFakeDb.data,

            // Contacts
            'contacts-contacts': ContactsFakeDb.contacts,
            'contacts-user'    : ContactsFakeDb.user,

            // Todo
            'todo-todos'  : TodoFakeDb.todos,
            'todo-filters': TodoFakeDb.filters,
            'todo-tags'   : TodoFakeDb.tags,

            // Profile
            'profile-timeline'     : ProfileFakeDb.timeline,
            'profile-photos-videos': ProfileFakeDb.photosVideos,
            'profile-about'        : ProfileFakeDb.about,

            // Search
            'search': SearchFakeDb.search,

            // FAQ
            'faq': FaqFakeDb.data,

            // Icons
            'icons': IconsFakeDb.icons,

            // Quick Panel
            'quick-panel-notes' : QuickPanelFakeDb.notes,
            'quick-panel-events': QuickPanelFakeDb.events
        };
    }
}

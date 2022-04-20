import { Route } from "@angular/router";
import { AppComponent } from "./app.component";
import { AppGuard } from "./app.guard";
import { DashboardComponent } from "./dashboard/dashboard/dashboard.component";
import { LoginComponent } from "./auth/login/login.component";

export const routes: Route[] = [
    {
        path     : 'dashboard',
        component: DashboardComponent,
        canActivate: [AppGuard],
    },
    {
        path     : 'login',
        component: LoginComponent,
    },
    {
        path     : '**',
        redirectTo: '/dashboard'
    },
];


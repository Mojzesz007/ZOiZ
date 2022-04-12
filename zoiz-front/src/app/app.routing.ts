import { Route } from "@angular/router";
import { AppComponent } from "./app.component";
import { AppGuard } from "./app.guard";
import { DashboardComponent } from "./dashboard/dashboard/dashboard.component";
import { LoginComponent } from "./login/login/login.component";

export const routes: Route[] = [
    {
        path     : '',
        component: AppComponent,
        children : [
            {
                path     : 'login',
                component: LoginComponent,
                
            },
            {
                path     : 'dashboard',
                component: DashboardComponent,
                canActivate: [AppGuard],
            },
            
        ]
    }
];


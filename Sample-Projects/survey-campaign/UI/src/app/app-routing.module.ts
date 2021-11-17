import { RegisterComponent } from './views/register/register.component';
import { LoginGuard } from './authguard/login.guard';
import { User } from './model/user';
import { NotfoundComponent } from './views/common/notfound/notfound.component';
import { LoginComponent } from './views/login/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'user',
    loadChildren: () => import('./views/user/user.module').then(m => m.UserModule),
    canActivate:[LoginGuard]
  },
  {
    path:'admin',
    loadChildren: () => import('./views/admin/admin.module').then(m => m.AdminModule),
    canActivate:[LoginGuard]
  },
  {
    path:'',
    redirectTo:'/login',
    pathMatch:'full'
  },
  {
    path:'**',
    component:NotfoundComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

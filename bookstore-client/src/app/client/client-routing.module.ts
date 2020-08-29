import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddClientComponent } from './add-client/add-client.component';
import {LoginComponent} from "./login/login.component";
import {ResetPasswordComponent} from "./reset-password/reset-password.component";

const routes: Routes = [
  { path: '',
    children: [
      {
        path:'add',
        component: AddClientComponent
      },
      {
        path:'login',
        component: LoginComponent

      },
      {
        path: 'resetPassword',
        component: ResetPasswordComponent
      }
    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }

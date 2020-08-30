import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { LoginComponent } from './login/login.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import {AddClientComponent} from "./add-client/add-client.component";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [AddClientComponent, LoginComponent, ResetPasswordComponent],
  imports: [
    CommonModule,
    ClientRoutingModule,
    ReactiveFormsModule
  ]
})
export class ClientModule { }

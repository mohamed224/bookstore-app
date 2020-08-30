import { Component, OnInit } from '@angular/core';
import {ClientService} from "../service/client.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Credential} from "../model/credential";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentialForm: FormGroup
  credential: Credential
  constructor(private clientService: ClientService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.credentialForm = this.fb.group({
      email:['',Validators.required],
      password:['',Validators.required]
    })
  }

  login() {
    this.credential = this.credentialForm.getRawValue();
    this.clientService.login(this.credential).
      subscribe(data=>{
        this.clientService.storedUserEmailInSession(data['email']);
        this.router.navigateByUrl('main/cart');
    })
  }

  goToCreateClientPage() {
    this.router.navigateByUrl('main/client/add');
  }

  resetPassword() {
    this.router.navigateByUrl('main/client/resetPassword');
  }
}

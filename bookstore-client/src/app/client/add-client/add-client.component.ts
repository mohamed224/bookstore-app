import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Client} from "../model/client";
import {ClientService} from "../service/client.service";
import {isAsciiLetter} from "codelyzer/angular/styles/chars";

@Component({
  selector: 'app-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  clientForm: FormGroup
  client: Client;
  constructor(private fb: FormBuilder, private router: Router, private clientService: ClientService) { }

  ngOnInit(): void {
    this.clientForm = this.fb.group({
      firstName : ['',Validators.required],
      lastName : ['',Validators.required],
      email : ['',Validators.required],
      address : ['',Validators.required],
      password : ['',Validators.required],
      phoneNumber : ['',Validators.required],

    })
  }

  save() {
    this.client = this.clientForm.getRawValue();
    this.clientService.register(this.client).
    subscribe(data=>{
      this.clientService.storedUserEmailInSession(data['email']);
      let clientCreatedSuccessMessage = `${data['firstName']} ${data['lastName']} votre compte à été bien crée.`;
      alert(clientCreatedSuccessMessage);
      this.router.navigateByUrl('main/cart');
    })
  }

  goToLoginPage() {
    this.router.navigateByUrl('main/client/login');
  }
}

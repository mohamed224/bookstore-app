import {Injectable} from '@angular/core';
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";
import {Observable} from "rxjs";
import {Client} from "../model/client";
import {Credential} from "../model/credential";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private genericService: GenericService) { }

  public login(credential: Credential): Observable<Client>{
    return this.genericService.callService(Operation.POST, 'clients/login',credential);
  }

  public register(client: Client){
    return this.genericService.callService(Operation.POST, 'clients/register',client);
  }

  public resetPassword(password: string){

  }

  public storedUserEmailInSession(email: string){
    localStorage.setItem('email',email);
  }

  public getUserEmailInSession(){
    return localStorage.getItem('email');
  }
}

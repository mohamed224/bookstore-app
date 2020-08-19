import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ConfigService} from "./config.service";
import {Operation} from "../utils/operations";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GenericService {

  private readonly connection: string;

  constructor(private httpClient: HttpClient, private configService: ConfigService) {
    this.connection = this.configService.config.serverUrl;
  }

  public callService(action: Operation, endPoint: string, data?: any, query ?: string, options?: any): Observable<any> | Observable<any[]> | any {

    switch (action) {
      case Operation.POST : {
        const qOptions: string = query ? `?${query}` : '';
        return this.httpClient.post(`${this.connection}/${endPoint}${qOptions}`, data , options);
      }
      case Operation.PUT : {
        if (data && !query) {
          return this.httpClient.put(`${this.connection}/${endPoint}/${data.id}`, data);
        } else {
          const qOptions: string = query ? `?${query}` : '';
          return this.httpClient.put(`${this.connection}/${endPoint}${qOptions}`, {});
        }

      }
      case Operation.GET : {
        const id: any = data ? data.id : '';
        const qOptions: string = query ? `?${query}` : '';
        return this.httpClient.get(`${this.connection}/${endPoint}/${id}${qOptions}`);
      }
      case Operation.DELETE : {
        return this.httpClient.delete(`${this.connection}/${endPoint}/${data.id}`);
      }
    }

  }
}

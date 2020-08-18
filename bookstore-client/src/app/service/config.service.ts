import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {of} from "rxjs";


interface IConfig {
  serverUrl: string
}

export function configServerInitFactory(config: ConfigService): Function {
  return () => config.load();
}

@Injectable()
export class ConfigService {

  config: IConfig;

  constructor() {
  }

  load(): Promise<any> {
    this.config = {
      serverUrl: environment.serverUrl
    };
    return of().toPromise();
  };

}

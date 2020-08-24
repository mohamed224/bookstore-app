import {BrowserModule} from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {configServerInitFactory, ConfigService} from "./service/config.service";
import {BooksModule} from "./books/books.module";
import {ContentModule} from "./content/content.module";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BooksModule,
    ContentModule

  ],
  providers: [
    ConfigService,
    {
      provide: APP_INITIALIZER,
      useFactory: configServerInitFactory,
      deps: [ConfigService],
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

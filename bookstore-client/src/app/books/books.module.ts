import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BooksRoutingModule} from './books-routing.module';
import {BooksComponent} from './list-book/books.component';
import {AddBookComponent} from './add-book/add-book.component';


@NgModule({
  declarations: [BooksComponent, AddBookComponent],
  imports: [
    CommonModule,
    BooksRoutingModule
  ]
})
export class BooksModule {
}

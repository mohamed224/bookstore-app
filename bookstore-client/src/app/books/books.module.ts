import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BooksRoutingModule} from './books-routing.module';
import {BooksComponent} from './list-book/books.component';
import {AddBookComponent} from './add-book/add-book.component';
import {ReactiveFormsModule} from "@angular/forms";
import {DetailBookComponent} from './detail-book/detail-book.component';


@NgModule({
  declarations: [BooksComponent, AddBookComponent, DetailBookComponent],
  imports: [
    CommonModule,
    BooksRoutingModule,
    ReactiveFormsModule
  ]
})
export class BooksModule {
}

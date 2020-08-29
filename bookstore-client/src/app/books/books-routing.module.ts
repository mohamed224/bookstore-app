import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {BooksComponent} from './list-book/books.component';
import {AddBookComponent} from "./add-book/add-book.component";

const routes: Routes = [
  {
    path:'',
    children: [
      {
        path: '',
        component: BooksComponent
      },
      {
        path: 'add',
        component: AddBookComponent
      },
      {
        path: 'edit/:id',
        component: AddBookComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule {
}

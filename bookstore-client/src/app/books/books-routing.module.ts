import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {BooksComponent} from './list-book/books.component';

const routes: Routes = [{path: 'book', component: BooksComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule {
}

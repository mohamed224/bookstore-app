import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


const routes: Routes = [
  {
    path: 'books',
    loadChildren: () => import('./books/books.module').then(m => m.BooksModule)
  },
  {
    path: 'content',
    loadChildren: () => import('./content/content.module').then(m => m.ContentModule)}
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

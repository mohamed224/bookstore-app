import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ContentComponent} from './list-content/content.component';

const routes: Routes = [
  {path: 'content', component: ContentComponent}
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContentRoutingModule {
}

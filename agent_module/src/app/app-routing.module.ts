import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAccommodationComponent } from './addAccommodation/addAccommodation';
import { ViewAllAccommodationsComponent } from './viewAllAccommodations/viewAllAccommodations';
import { LoginComponent } from './login/login';
import { MessageComponent } from './messages/messages';
const routes: Routes = [
  { path: 'agent/addAccommodation', component: AddAccommodationComponent },
  { path: 'agent/viewAllAccommodations', component: ViewAllAccommodationsComponent },
  { path: 'agent/messages', component: MessageComponent },
  { path: '', redirectTo: 'agent/login', pathMatch: 'full' },
  { path: 'agent/login', component: LoginComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
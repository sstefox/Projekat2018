import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home';
import { ResultComponent } from './results/result';
import { AccommodationResultComponent } from './accommodationResult/accommodationResult';
import { ViewReservationsComponent } from './viewReservations/viewReservations';
import { ViewMessagesComponent } from './viewMessages/viewMessages';
import { AuthService } from './services/auth.service';
import { HttpClientModule } from '@angular/common/http'; 
import { LoginComponent } from './login/login';
import { TokenStorage} from './token/token.storage';
const routes: Routes = [
  { path: 'client/home', component: HomeComponent },
  { path: 'client/results', component: ResultComponent },
  { path: 'client/accommodation/result', component: AccommodationResultComponent },
  { path: 'client/view/reservations', component: ViewReservationsComponent },
  { path: 'client/login', component: LoginComponent },
  { path: 'client/viewMessages',component:ViewMessagesComponent},
  { path: '', redirectTo: 'client/home', pathMatch: 'full' },
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }

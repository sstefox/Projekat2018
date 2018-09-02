import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome';
import { HomeComponent } from './home/home';
import { AccommodationTypeComponent } from './accommodationType/accommodationType';
import { AccommodationCategoryComponent } from './accommodationCategory/accommodationCategory';
import { UsersComponent } from './users/users';
import { CommentsComponent } from './comments/comments';
import { AdditionalServicesComponent } from './additionalServices/additionalServices';
import { CertificatesComponent } from './certificates/certificates';
import { AccommodationsComponent } from './accommodations/accommodations';
import { LoginComponent } from './login/login';
const routes: Routes = [
  { path: 'admin/welcome', component: WelcomeComponent },
  { path: 'admin/home', component: HomeComponent },
  { path: 'admin/accommodationType', component: AccommodationTypeComponent },
  { path: 'admin/accommodationCategory', component: AccommodationCategoryComponent },
  { path: 'admin/users', component: UsersComponent },
  { path: 'admin/comments', component: CommentsComponent },
  { path: 'admin/additionalServices', component: AdditionalServicesComponent },
  { path: 'admin/certificates', component: CertificatesComponent },
  { path: 'admin/accommodations', component: AccommodationsComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }

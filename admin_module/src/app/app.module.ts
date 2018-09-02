import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { RouterModule, Routes, provideRoutes } from '@angular/router';
import { AppRoutingModule } from './/app-routing.module';
import { WelcomeComponent } from './welcome/welcome';
import { HomeComponent } from './home/home';
import { MenuComponent } from './menu/menu';
import { AccommodationTypeComponent } from './accommodationType/accommodationType';
import { AccommodationCategoryComponent } from './accommodationCategory/accommodationCategory';
import { UsersComponent } from './users/users';
import { CommentsComponent } from './comments/comments';
import { AdditionalServicesComponent } from './additionalServices/additionalServices';
import { CertificatesComponent } from './certificates/certificates';
import { AccommodationsComponent } from './accommodations/accommodations';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule, MatPaginatorModule, MatSortModule, MatTableModule } from "@angular/material";
import { LoginComponent } from './login/login';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { HttpClientModule } from '@angular/common/http'; 
import { TokenStorage} from './token/token.storage';
@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    HomeComponent,
    MenuComponent,
    AccommodationTypeComponent,
    AccommodationCategoryComponent,
    UsersComponent,
    CommentsComponent,
    AdditionalServicesComponent,
    CertificatesComponent,
    AccommodationsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    
    TokenStorage
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

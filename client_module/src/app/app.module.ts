import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes, provideRoutes } from '@angular/router';
import { AppRoutingModule } from './/app-routing.module';
import { MatInputModule, MatPaginatorModule, MatSortModule, MatTableModule } from "@angular/material";
import { HomeComponent } from './home/home';
import { ResultComponent } from './results/result';
import { HttpModule, JsonpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { NgDatepickerModule } from 'ng2-datepicker';
import { accommodationService } from './services/accommodationService';
import { AccommodationResultComponent } from './accommodationResult/accommodationResult';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ViewReservationsComponent } from './viewReservations/viewReservations';
import { LoginComponent } from './login/login';
import { AuthService } from './services/auth.service';
import { HttpClientModule } from '@angular/common/http'; 
import { TokenStorage} from './token/token.storage';
import { MenuComponent } from './menu/menu';
import  { ViewMessagesComponent} from './viewMessages/viewMessages';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ResultComponent,
    AccommodationResultComponent,
    ViewReservationsComponent,
    LoginComponent,
    MenuComponent,
    ViewMessagesComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    FormsModule,
    HttpModule,
    NgDatepickerModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [
    accommodationService,
    AuthService,
    TokenStorage
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, provideRoutes } from '@angular/router';
import { AppRoutingModule } from './/app-routing.module';
import { AppComponent } from './app.component';
import { AddAccommodationComponent } from './addAccommodation/addAccommodation';
import { HttpModule, JsonpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { ViewAllAccommodationsComponent } from './viewAllAccommodations/viewAllAccommodations';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule, MatPaginatorModule, MatSortModule, MatTableModule } from "@angular/material";
import { NgDatepickerModule } from 'ng2-datepicker';
import { MenuComponent } from './menu/menu';
import { LoginComponent } from './login/login';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MessageComponent } from './messages/messages';
import { TokenStorage} from './token/token.storage';
import { AuthService } from './services/auth.service';
import { HttpClientModule } from '@angular/common/http'; 
@NgModule({
  declarations: [
    AppComponent,
    AddAccommodationComponent,
    ViewAllAccommodationsComponent,
    MenuComponent,
    LoginComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    AppRoutingModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    NgDatepickerModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    TokenStorage
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

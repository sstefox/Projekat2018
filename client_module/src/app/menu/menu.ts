import { Component, ViewChild, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { TokenStorage } from '../token/token.storage';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.html',
  styleUrls: ['./menu.css']
})
export class MenuComponent {
  tokenVal: string;
  constructor(private http: Http, private token: TokenStorage, private router: Router) {
    this.tokenVal = this.token.getToken();
  }
  logout() {
    console.log("singout");

    this.token.signOut();
    if (this.token.getToken() === null) {
      this.router.navigate(['/']);
    }
  }
  viewMessages() {
    this.router.navigate(['client/viewMessages']);
  }
  viewReservations() {
    this.router.navigate(['/client/view/reservations']);
  }
}
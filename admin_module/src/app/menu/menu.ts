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

  constructor(private http: Http, private token: TokenStorage, private router: Router) {
  }
  logout(){
    console.log("singout");
    this.token.signOut();
    if(this.token.getToken()===null){
      this.router.navigate(['/']);
    }
  }
}
import { Component, ViewChild, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { commentmodel } from '../models/commentmodel';
import { usermodel } from '../models/usersmodel';
import { AuthService } from '../services/auth.service';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent implements OnInit {
  headers = new Headers();
  options: RequestOptions;
  username: string;
  user: usermodel;
  registeruser:usermodel;
  show: boolean;
  forgetPasswordFlag:boolean;
  changeUser:usermodel;
  regStat : string;
  constructor(private http: Http, private router: Router, private authService: AuthService, private token: TokenStorage) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT');
    this.options = new RequestOptions({ headers: this.headers });
    this.user = new usermodel();
    this.registeruser  = new usermodel();
    this.changeUser = new usermodel();
    this.show = false;
    this.regStat = '';
  }
  register(data){
    this.http.post(Constants.API_ENDPOINT+'token/register', JSON.stringify(data), this.options)
      .subscribe((json: Object) => {
        console.log(json['_body']);
        if(json['_body']==="SUCCESS"){
            this.regStat = "User Saved..!! Contact Admin for activation..!! Reload the page to continue..!!";
        }
      },
      err => { console.error(err) }
      );
  }
  forgetPassword(){
    if(this.forgetPasswordFlag === false){
      this.forgetPasswordFlag = true;
    }else{
      this.forgetPasswordFlag = false;
    }
  }
  showpassword() {
    this.show = !this.show;
}
  ngOnInit() {
  }
  login() {
    this.authService.attemptAuth(this.user.username, this.user.password).subscribe(
      result => {
        this.token.saveToken(result['token']);
        if(this.token.getToken()){
          this.router.navigate(['client/home']);
        }
      }
    );
  }

  changePassword(data){
    this.http.post(Constants.API_ENDPOINT+'token/forgetPassword', JSON.stringify(this.changeUser), this.options)
      .subscribe((json: Object) => {
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
}
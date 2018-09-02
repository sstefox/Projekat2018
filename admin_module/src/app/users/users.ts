import { Component, ViewChild, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { usermodel } from '../models/usersmodel';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-users',
  templateUrl: './users.html',
  styleUrls: ['./users.css']
})
export class UsersComponent implements OnInit {
  userFlag: boolean;
  role: number;
  user: usermodel;
  userEntity:usermodel;
  options: RequestOptions;
  headers = new Headers();
  userList: usermodel[];
  roleVal : number;
  status:string;
  displayedColumns: string[] = ['firstName', 'role', 'username', 'status', 'change'];
  dataSource: MatTableDataSource<usermodel>;
  map = new Map<string, string>();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private http: Http, private token: TokenStorage, private router: Router) {
    this.user = new usermodel();
    this.userEntity = new usermodel();
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('Authorization', 'Bearer ' + this.token.getToken());
    this.options = new RequestOptions({ headers: this.headers });
    this.userList = [];
    this.http.get(Constants.API_ENDPOINT+'admin/viewAllUsers', this.options)
      .subscribe(
      json => {
        this.userList = json.json();
        this.dataSource = new MatTableDataSource(this.userList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
  }
  onClicked(row) {
    var temp = row.target.value;
    var x = temp.split(",");
    this.map.set(x[0], x[1]);
  }
  save(data) {
    this.userEntity.firstName = this.user.firstName;
    this.userEntity.lastName = this.user.lastName;
    this.userEntity.address = this.user.address;
    this.userEntity.email = this.user.email;
    this.userEntity.bNumber = this.user.bNumber;
    this.userEntity.role = this.roleVal;
    this.userEntity.phoneNumber = this.user.phoneNumber;
    console.log(this.userEntity);
    this.http.post(Constants.API_ENDPOINT+'admin/addNewUser', JSON.stringify(data), this.options)
      .subscribe((json: Object) => {
        window.location.reload();
        this.status = json['_body'];
      },
      err => { console.error(err) }
      );
  }
  ngOnInit() {
  }
  updateStatus() {
    const convMap = {};
    this.map.forEach((val: string, key: string) => {
      convMap[key] = val;
    });
    this.http.post(Constants.API_ENDPOINT+'admin/updateUserStatus', convMap, this.options)
      .subscribe((json: Object) => {
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
    onChange(event){
      this.roleVal = event.target.value;
      if(this.roleVal==2){
        this.userFlag = true;
      }else{
        this.userFlag = false;
      }
    }
randomPassword(length) {
    var chars = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()-+<>ABCDEFGHIJKLMNOP1234567890";
    var pass = "";
    for (var x = 0; x < length; x++) {
        var i = Math.floor(Math.random() * chars.length);
        pass += chars.charAt(i);
    }
    this.user.password = pass;
}
}
import { Component, ViewChild, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { TokenStorage } from '../token/token.storage';
import { messagemodel } from '../models/messagemodel';
@Component({
  selector: 'app-viewMessages',
  templateUrl: './viewMessages.html',
  styleUrls: ['./viewMessages.css']
})
export class ViewMessagesComponent {
  tokenVal: string;
  options: RequestOptions;
  byMsgList: messagemodel[];
  fromMsgList:messagemodel[];
  headers = new Headers();
  constructor(private http: Http, private token: TokenStorage, private router: Router) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('authorization', 'Bearer ' + this.token.getToken());
    this.options = new RequestOptions({ headers: this.headers });
    this.byMsgList = [];
    this.fromMsgList = [];
    this.http.get('http://localhost:8080/client/getMessagesToUserId', this.options)
            .subscribe(
            json => {
                console.log(json.json());
                this.byMsgList = json.json();
            });
    this.http.get('http://localhost:8080/client/getMessagesByUserId', this.options)
            .subscribe(
            json => {
               console.log(json.json());
                this.fromMsgList = json.json();
            });
  }
}
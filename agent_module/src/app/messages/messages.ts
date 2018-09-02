import { Component } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { accommodation } from '../models/accommodation';
import { messagemodel } from '../models/messagemodel';
import { TokenStorage } from '../token/token.storage';
import { Constants} from '../models/constants';
@Component({
  selector: 'app-messages',
  templateUrl: './messages.html',
  styleUrls: ['./messages.css']
})
export class MessageComponent {
  services: string[];
  accTypes: string[];
  selectedServices: string[];
  messageList: messagemodel[];
  messageModel:messagemodel;
  options: RequestOptions;
  headers = new Headers();
  messageFlag:boolean;
  image: any;
  temp: any;
  newid:number;
  accommodationId:number;
  msgId:number;
  constructor(private http: Http, private router: Router, private token: TokenStorage) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('Authorization', 'Bearer ' + this.token.getToken());
    this.messageList = [];
    this.selectedServices = [];
    this.image = [];
    this.temp = [];
    this.messageFlag = false;
    this.messageModel = new messagemodel();
    this.options = new RequestOptions({ headers: this.headers });
    this.http.get(Constants.API_ENDPOINT+'agent/getMessagesForUser', this.options)
      .subscribe(json  => {
        console.log(json.json());
        this.messageList = json.json();
        console.log(this.messageList);
      },
      err => { console.error(err) }
      );
  }
  markMessage(id,accId,msgId){
    this.newid = id;
    this.accommodationId = accId;
    this.msgId = msgId;
    console.log(this.newid);
    if(this.messageFlag===true){
      this.messageFlag= false;
    }else{
      this.messageFlag=true;
    }
  }
  sendMessage(data){
    console.log(data);
    console.log(this.newid);
    this.http.get(Constants.API_ENDPOINT+'agent/sendMessages/'+data['message']+'/'+this.newid+'/'+ this.accommodationId+'/'+this.msgId, this.options)
      .subscribe(json  => {
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
}
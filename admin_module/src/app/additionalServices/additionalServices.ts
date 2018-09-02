import { Component } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { additionalService } from '../models/additionalService';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-additionalServices',
  templateUrl: './additionalServices.html',
  styleUrls: ['./additionalServices.css']
})
export class AdditionalServicesComponent {
  additionalService: additionalService;
  headers = new Headers();
  options: RequestOptions;
  result: additionalService[];
  constructor(private http: Http, private router: Router, private token: TokenStorage) {
    this.additionalService = new additionalService();
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('Authorization', 'Bearer ' + this.token.getToken());
    this.options = new RequestOptions({ headers: this.headers });
    this.http.get(Constants.API_ENDPOINT+'admin/viewAllAdditionalServices', this.options)
      .subscribe(
      json => {
        this.result = json.json();
      });
  }
  save(data) {
    this.http.post(Constants.API_ENDPOINT+'admin/addNewAdditionalService', JSON.stringify(data), this.options)
      .subscribe((json: Object) => {
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
}
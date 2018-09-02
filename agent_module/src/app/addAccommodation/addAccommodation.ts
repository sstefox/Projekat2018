import { Component } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { accommodation } from '../models/accommodation';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-addAccommodation',
  templateUrl: './addAccommodation.html',
  styleUrls: ['./addAccommodation.css']
})
export class AddAccommodationComponent {
  services: string[];
  accTypes: string[];
  selectedServices: string[];
  accommodation: accommodation;
  options: RequestOptions;
  headers = new Headers();
  image:any;
  temp :any;
  constructor(private http: Http, private router: Router, private token: TokenStorage) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('Authorization', 'Bearer ' + this.token.getToken());
    this.accommodation = new accommodation();
    this.selectedServices = [];
    this.image = [];
    this.temp = [];
    this.options = new RequestOptions({ headers: this.headers });
    this.http.get(Constants.API_ENDPOINT+'agent/viewAllAccommodationTypes', this.options)
      .subscribe(
      json => {
        this.accTypes = json.json();
      });
    this.http.get(Constants.API_ENDPOINT+'agent/viewAllAdditionalServices', this.options)
      .subscribe(
      json => {
        this.services = json.json();
      });
  }
  checked(selectedValue: string) {
    this.selectedServices.push(selectedValue);
  }
  save(data) {
    this.accommodation.services  = this.selectedServices;
    this.http.post(Constants.API_ENDPOINT+'agent/addNewAccommodation', JSON.stringify(this.accommodation), this.options)
      .subscribe((json: Object) => {
        this.router.navigate(['agent/viewAllAccommodations']);
      },
      err => { console.error(err) }
      );
  }
}
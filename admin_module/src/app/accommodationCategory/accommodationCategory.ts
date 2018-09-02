import { Component } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { accommodationCategory } from '../models/accommodationCategory';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-accommodationCategory',
  templateUrl: './accommodationCategory.html',
  styleUrls: ['./accommodationCategory.css']
})
export class AccommodationCategoryComponent {
  result: accommodationCategory[]
  options: RequestOptions;
  headers = new Headers();
  accommodationCategory: accommodationCategory;
  constructor(private http: Http, private router: Router,private token: TokenStorage) {
    this.accommodationCategory = new accommodationCategory();
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set( 'Authorization', 'Bearer ' + this.token.getToken());
    this.options = new RequestOptions({ headers: this.headers });
    this.http.get(Constants.API_ENDPOINT+'admin/viewAllAccommodationCategories', this.options  )
      .subscribe(
      json => {
        this.result = json.json();
      });
  }
  save(data) {
    this.http.post(Constants.API_ENDPOINT+'admin/addNewAccommodationCategory', JSON.stringify(data), this.options)
      .subscribe((json: Object) => {
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
}
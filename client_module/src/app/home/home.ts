import { Component, OnInit, ViewChild,OnDestroy } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { additionalService } from '../models/additionalService';
import { accommodationType } from '../models/accommodationType';
import { accommodationCategory } from '../models/accommodationCategory';
import { search } from '../models/search';
import { accommodation } from '../models/accommodation';
import {accommodationService} from '../services/accommodationService';
@Component({
  selector: 'table-overview-example',
  styleUrls: ['home.css'],
  templateUrl: 'home.html',
})
export class HomeComponent implements OnInit, OnDestroy{
  showFlag: boolean;
  options: RequestOptions;
  headers = new Headers();
  services: additionalService[];
  accTypes: accommodationType[];
  categories: accommodationCategory[];
  searchModel: search;
  type:number;
  serviceList:string[];
  accommodationList:accommodation[];
  category :string;
  constructor(private http: Http, private router: Router,public accommodationService:accommodationService) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.options = new RequestOptions({ headers: this.headers });
    this.searchModel = new search();
    this.accommodationList = [];
    this.type = 0;
    this.serviceList = [];
    this.showFlag = false;
    this.http.get('http://localhost:8080/get/viewAllAccommodationTypes', this.options)
      .subscribe(
      json => {
        this.accTypes = json.json();
      });
    this.http.get('http://localhost:8080/get/viewAllAdditionalServices', this.options)
      .subscribe(
      json => {
        this.services = json.json();
      });
    this.http.get('http://localhost:8080/get/viewAllAccommodationCategories', this.options)
      .subscribe(
      json => {
        this.categories = json.json();
      });
  }

  ngOnInit() {
  }
  advanceSearch() {
    if (this.showFlag == true) {
      this.showFlag = false;
    } else {
      this.showFlag = true;
    }
  }
  onItemChange(val){
    this.category = val;
  }
  onTypeClicked(event){
    this.type=event;
  }
  onServiceClicked(event){
    if(event.target.checked){
            this.serviceList.push(event.target.value);
        }else{
            var temp = this.serviceList.indexOf(event.target.value);
            if(temp>=0){
                this.serviceList.splice(temp,1);
            }
        }
          console.log(this.serviceList);
  }
  search() {
    let searchObj : search;
    searchObj = new search();
    searchObj.capacity = this.searchModel.capacity;
    searchObj.location = this.searchModel.location;
    searchObj.fromDate = new Date(this.searchModel.fromDate['year'], this.searchModel.fromDate['month'] - 1, this.searchModel.fromDate['day']).toString();
    searchObj.toDate = new Date(this.searchModel.toDate['year'], this.searchModel.toDate['month'] - 1, this.searchModel.toDate['day']).toString();
    searchObj.serviceList = this.serviceList;
    searchObj.type=this.type;
    searchObj.category = this.category;
    if(this.showFlag===false){    
      this.http.post('http://localhost:8080/search/searchAccommodation', JSON.stringify(searchObj), this.options)
      .subscribe(json => {
        this.accommodationList.push(json.json());
        this.accommodationService.accommodations= json;
        this.router.navigateByUrl('/client/results');
      },
      err => { console.error(err) }
      );
    }else{
      console.log(this.showFlag);
      this.http.post('http://localhost:8080/search/advanceSearchAccommodation', JSON.stringify(searchObj), this.options)
      .subscribe(json => {
        this.accommodationList.push(json.json());
        this.accommodationService.accommodations= json;
        this.router.navigateByUrl('/client/results');
      },
      err => { console.error(err) }
      );
    }
  }
    ngOnDestroy() {
  }
}



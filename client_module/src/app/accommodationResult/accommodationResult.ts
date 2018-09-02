import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { additionalService } from '../models/additionalService';
import { accommodationType } from '../models/accommodationType';
import { accommodationCategory } from '../models/accommodationCategory';
import { accommodation } from '../models/accommodation';
import { review } from '../models/review';
import { reservation } from '../models/reservation';
import { accommodationService } from '../services/accommodationService';
import { messagemodel } from '../models/messagemodel';
import { AuthService } from '../services/auth.service';
import { TokenStorage } from '../token/token.storage';
@Component({
    selector: 'accommodation-result',
    styleUrls: ['accommodationResult.css'],
    templateUrl: 'accommodationResult.html',
})
export class AccommodationResultComponent implements OnInit {
    options: RequestOptions;
    headers = new Headers();
    accommodationResult: accommodation;
    message:messagemodel;
    reviewList: review[];
    reservationModel: reservation;
    accommodationId: number;
    commentData: review;
    rateVal: string;
    accId: string;
    dataList: any;
    imgList: any;
    ulist: any;
    totalAmount: number;
    constructor(public accommodationService: accommodationService, private http: Http, private router: Router,private token: TokenStorage) {
        this.headers.set('Content-Type', 'application/json');
        this.headers.set('Access-Control-Allow-Origin', '*');
        
        this.accommodationResult = new accommodation();
        this.commentData = new review();
        this.dataList = [];
        this.imgList = [];
        this.ulist = [];
        this.message= new messagemodel();
        this.reservationModel = new reservation();
        this.options = new RequestOptions({ headers: this.headers });
        this.http.get('http://localhost:8080/get/getAccommodationById/' + this.accommodationService.accId + '/', this.options)
            .subscribe(
            json => {
                this.accommodationResult = json.json();
            });
        this.http.get('http://localhost:8080/get/getReviewsById/' + this.accommodationService.accId + '/', this.options)
            .subscribe(
            json => {
                this.reviewList = json.json();
            });

    }
    ngOnInit() {
        this.accommodationId = this.accommodationService.accId;
    }
    book(val) {
        if(this.token.getToken()==null){
            this.router.navigateByUrl('/client/login');
        }
    }
    contact(val) {
        
        if(this.token.getToken()==null){
            this.router.navigateByUrl('/client/login');
        }
    }
    savemessage(val){
        this.headers.set( 'Authorization', 'Bearer ' + this.token.getToken());
        this.options = new RequestOptions({ headers: this.headers });
        let msg = val['message'];
        var accId = this.accommodationService.accId;
        this.http.get('http://localhost:8080/client/saveMessage/'+msg+'/'+accId+'/' , this.options)
            .subscribe((json: Object) => {
                this.router.navigateByUrl('/client/home');
            },
            err => { console.error(err) }
            );
    }
    viewImages(val) {
        this.http.get('http://localhost:8080/get/getImages/' + this.accommodationService.accId + '/', this.options)
            .subscribe(
            json => {
                this.dataList = json.json();
            });
        this.imgList = [];
        this.ulist = [];
        if (this.dataList.length > 0) {
            for (let t of this.dataList) {
                this.http.get('http://localhost:8080/get/getImages/' + this.accommodationService.accId + '/' + t, this.options)
                    .subscribe(event => {
                        this.ulist = event;
                        this.imgList.push(this.ulist._body);
                    });
            }
        }
    }
    rate(val) {
        if(this.token.getToken()==null){
            this.router.navigateByUrl('/client/login');
        }
    }
    rateFormSubmit(data) {
       this.headers.set( 'Authorization', 'Bearer ' + this.token.getToken());
       this.options = new RequestOptions({ headers: this.headers });
        let params = new URLSearchParams();
        params.append('rate', this.rateVal);
        params.append('comment', this.commentData.comment);
        params.append('accommodationId', this.accId);
        var commentVal = this.commentData.comment;
        var rating = this.rateVal;
        var accId = this.accommodationService.accId;
        this.http.post('http://localhost:8080/client/rateAccommodation/' + rating + '/' + commentVal + '/' + accId,null, this.options)
            .subscribe((json: Object) => {
                this.router.navigateByUrl('/client/results');
            },
            err => { console.error(err) }
            );
    }
    reservationFormSubmit(data) {
        this.calculate();
        this.headers.set( 'Authorization', 'Bearer ' + this.token.getToken());
        this.options = new RequestOptions({ headers: this.headers });
        let reservationRequest: reservation;
        reservationRequest = new reservation();
        reservationRequest.capacity = data['capacity'];
        reservationRequest.price = this.totalAmount.toString();
        reservationRequest.accommodationId = this.accommodationService.accId;
        reservationRequest.fromDate = new Date(this.reservationModel.fromDate['year'], this.reservationModel.fromDate['month'] - 1, this.reservationModel.fromDate['day']).toString();
        reservationRequest.toDate = new Date(this.reservationModel.toDate['year'], this.reservationModel.toDate['month'] - 1, this.reservationModel.toDate['day']).toString();
        this.http.post('http://localhost:8080/client/saveReservation/' , JSON.stringify(reservationRequest), this.options)
            .subscribe((json: Object) => {
                this.router.navigateByUrl('/client/results');
            },
            err => { console.error(err) }
            );
    }
    calculate() {
        let date1 = new Date(this.reservationModel.fromDate['year'], this.reservationModel.fromDate['month'] - 1, this.reservationModel.fromDate['day']);
        let date2 = new Date(this.reservationModel.toDate['year'], this.reservationModel.toDate['month'] - 1, this.reservationModel.toDate['day']);
        var diff = Math.abs(date1.getTime() - date2.getTime());
        var diffDays = Math.ceil(diff / (1000 * 3600 * 24));
        this.totalAmount = diffDays * this.accommodationResult.price;
    }
}
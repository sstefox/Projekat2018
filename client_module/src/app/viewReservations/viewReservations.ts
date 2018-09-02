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
import { TokenStorage } from '../token/token.storage';
import { AuthService } from '../services/auth.service';
@Component({
    selector: 'view-reservations',
    styleUrls: ['viewReservations.css'],
    templateUrl: 'viewReservations.html',
})
export class ViewReservationsComponent implements OnInit {
    accommodationId: number;
    options: RequestOptions;
    headers = new Headers();
    reservationList:reservation[];
    checkedList:string[];
    displayedColumns: string[] = ['title', 'capacity', 'price', 'fromDate', 'toDate','status','change'];
    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;
    dataSource: MatTableDataSource<reservation>;
    constructor(public accommodationService: accommodationService, private http: Http, private router: Router,private token: TokenStorage) {
        this.reservationList = [];
        this.headers.set('Content-Type', 'application/json');
        this.headers.set('Access-Control-Allow-Origin', '*');
        this.headers.set( 'authorization', 'Bearer ' + this.token.getToken());
        this.options = new RequestOptions({ headers: this.headers });
        this.checkedList = [];
        this.http.get('http://localhost:8080/client/getReservationsByUserId', this.options)
            .subscribe(
            json => {
                this.reservationList = json.json();
                this.dataSource = new MatTableDataSource(this.reservationList);
                console.log(this.reservationList);
            });
    }
    onClicked(event) {
        if(event.target.checked){
            this.checkedList.push(event.target.value);
        }else{
            var temp = this.checkedList.indexOf(event.target.value);
            if(temp>=0){
                this.checkedList.splice(temp,1);
            }
        }
    }
    deleteReservations(){
        this.headers.set( 'Authorization', 'Bearer ' + this.token.getToken());
        this.options = new RequestOptions({ headers: this.headers });
        this.http.post('http://localhost:8080/client/cancelBookings',this.checkedList, this.options)
            .subscribe((json: Object) => {
                console.log(json);
                window.location.reload();
            },
                        err => { console.error(err) }
                );
    }
    ngOnInit() {
        this.accommodationId = this.accommodationService.accId;
    }
}
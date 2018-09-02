import { Component,ViewChild,OnInit  } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { accommodation } from '../models/accommodation';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-accommodations',
  templateUrl: './accommodations.html',
  styleUrls: ['./accommodations.css']
})
export class AccommodationsComponent  implements OnInit {
    accommodationList:accommodation[];
    displayedColumns: string[] = ['location', 'price','services','username','status','publish'];
    headers = new Headers();
    options:RequestOptions;
    dataSource: MatTableDataSource<accommodation>;
    checkedList:string[];
    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;
    constructor(private http: Http, private router: Router,private token: TokenStorage) {
        this.headers.set('Content-Type','application/json');
        this.headers.set('Access-Control-Allow-Origin', '*');
        this.headers.set( 'Authorization', 'Bearer ' + this.token.getToken());
        this.options = new RequestOptions({ headers: this.headers });
        this.checkedList = [];
        this.http.get(Constants.API_ENDPOINT+'admin/viewAllAccommodations',this.options  )
        .subscribe(
            json => {
                console.log( json.json());
            this.accommodationList = json.json();
            this.dataSource = new MatTableDataSource(this.accommodationList);
            this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;
        });
    }
    ngOnInit() {
  }
    updateStatus(){
        this.http.post(Constants.API_ENDPOINT+'admin/updateAccommodationStatus',this.checkedList, this.options)
            .subscribe((json: Object) => {
                window.location.reload();
            },
                        err => { console.error(err) }
                );
    }
    onClicked(option, event) {
        if(event.target.checked){
            this.checkedList.push(event.target.value);
        }else{
            var temp = this.checkedList.indexOf(event.target.value);
            if(temp>=0){
                this.checkedList.splice(temp,1);
            }
        }
    }
}
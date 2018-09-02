import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { accommodation } from '../models/accommodation';
import { accommodationService } from '../services/accommodationService';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
@Component({
  selector: 'table-overview-example',
  styleUrls: ['result.css'],
  templateUrl: 'result.html',
})
export class ResultComponent implements OnInit, OnDestroy {
  accommodationList: accommodation[];
  displayedColumns: string[] = ['title', 'type', 'price', 'rating', 'category'];
  headers = new Headers();
  options: RequestOptions;
  requestId: number;
  dataSource: MatTableDataSource<accommodation>;
  accList = [];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(public accommodationService: accommodationService, private http: Http, private router: Router) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.options = new RequestOptions({ headers: this.headers });
    this.accommodationList = this.accommodationService.accommodations.json();
    this.dataSource = new MatTableDataSource(this.accommodationList);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  ngOnInit() {
  }
  ngOnDestroy() {
    this.accommodationService.accId = this.requestId;
  }
  linkReq(reqId) {
    this.requestId = reqId;
  }
}
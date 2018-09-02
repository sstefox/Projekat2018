import { Component, ViewChild, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { accommodation } from '../models/accommodation';
import { reservation } from '../models/reservation';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { commentmodel } from '../models/commentmodel';
import { TokenStorage } from '../token/token.storage';
import { Constants } from '../models/constants';
@Component({
  selector: 'app-viewAllAccommodations',
  templateUrl: './viewAllAccommodations.html',
  styleUrls: ['./viewAllAccommodations.css']
})
export class ViewAllAccommodationsComponent implements OnInit {
  accommodationList: accommodation[];
  displayedColumns: string[] = ['title', 'price', 'capacity', 'type', 'options'];
  headers = new Headers();
  options: RequestOptions;
  userlist: string[];
  reservationList: reservation[];
  commentList: commentmodel[];
  dataSource: MatTableDataSource<accommodation>;
  flag: boolean;
  selectedFile: File[];
  imgList: any;
  dataList: any;
  ulist: any;
  fileName: string;
  reservationModel: reservation;
  selectList: string[];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private http: Http, private router: Router, private token: TokenStorage) {
    this.headers.set('Content-Type', 'application/json');
    this.headers.set('Access-Control-Allow-Origin', '*');
    this.headers.set('Authorization', 'Bearer ' + this.token.getToken());
    this.options = new RequestOptions({ headers: this.headers });
    this.flag = false;
    this.selectedFile = [];
    this.commentList = [];
    this.imgList = [];
    this.dataList = [];
    this.ulist = [];
    this.reservationList = [];
    this.reservationModel = new reservation();
    this.fileName = '';
    this.selectList = [];
    this.http.get(Constants.API_ENDPOINT+'agent/viewAllAccommodations', this.options)
      .subscribe(
      json => {
        this.accommodationList = json.json();
        this.dataSource = new MatTableDataSource(this.accommodationList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
    this.http.get(Constants.API_ENDPOINT+'agent/getAllUsers', this.options)
      .subscribe(
      json => {
        this.userlist = json.json();
      });
  }
  ngOnInit() {

  }
  getImages(event) {
    var temp = event.target.id;
    temp = temp.substr(1, temp.length);

    this.http.get(Constants.API_ENDPOINT+'agent/getImages/' + temp, this.options)
      .subscribe(
      json => {
        this.dataList = json.json();
      });
    this.imgList = [];
    this.ulist = [];
    if (this.dataList.length > 0) {
      for (let t of this.dataList) {
        this.http.get(Constants.API_ENDPOINT+'agent/getImages/' + temp + '/' + t, this.options)
          .subscribe(event => {
            this.ulist = event;
            this.imgList.push(this.ulist._body);
          });
      }
    }
  }
  approveReservations() {
    this.http.post(Constants.API_ENDPOINT+'agent/updateReservationStatus', this.selectList, this.options)
      .subscribe((json: Object) => {
        console.log(json);
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
  onChange(event) {
    if (event.target.checked) {
      this.selectList.push(event.target.value);
    } else {
      var t = this.selectList.indexOf(event.target.value);
      if (t >= 0) {
        this.selectList.splice(t, 1);
      }
    }
    console.log(this.selectList);
  }
  close() {
    this.fileName = '';
    this.selectedFile = [];
  }
  onFileChanged(event) {
    this.fileName = event.target.files[0].name;
    console.log(this.fileName);
    this.selectedFile.push(event.target.files[0]);
    this.flag = false;
  }
  addimages(event) {
    if (this.flag == false) {
      this.flag = true;
    } else {
      this.flag = false;
    }
  }
  getComments(event) {
    var eventId = event.target.id;
    var accId = eventId.substr(1);
    this.http.get(Constants.API_ENDPOINT+'agent/getReviewsById/' + accId, this.options)
      .subscribe(
      json => {
        this.commentList = json.json();
      });
  }
  getReservations(event) {
    var eventId = event.target.id;
    var accId = eventId.substr(1);
    this.http.get(Constants.API_ENDPOINT+'agent/getAllReservations/' + accId, this.options)
      .subscribe(
      json => {
        this.reservationList = json.json();
      });
  }
  addreservation(event, t) {
    this.reservationModel.accommodationId = t;
    let savereservationModel: reservation;
    savereservationModel = new reservation();
    savereservationModel.accommodationId = t;
    savereservationModel.capacity = this.reservationModel.capacity;
    savereservationModel.username = this.reservationModel.username;
    savereservationModel.id = this.reservationModel.id;
    savereservationModel.price = this.reservationModel.price;
    let date1 = new Date(this.reservationModel.fromDate['year'], this.reservationModel.fromDate['month'] - 1, this.reservationModel.fromDate['day']);
    let date2 = new Date(this.reservationModel.toDate['year'], this.reservationModel.toDate['month'] - 1, this.reservationModel.toDate['day']);
    savereservationModel.fromDate = date1.toString();
    savereservationModel.toDate = date2.toString();    
    console.log(savereservationModel);
    this.http.post(Constants.API_ENDPOINT+'agent/addNewReservation', JSON.stringify(savereservationModel), this.options)
      .subscribe((json: Object) => {
        window.location.reload();
      },
      err => { console.error(err) }
      );
  }
  onUpload(accId) {
    const uploadData = new FormData();
    for (let file of this.selectedFile) {
      uploadData.append('file[]', file);
    }    
    uploadData.append('accommodationId',accId);
    this.http.post(Constants.API_ENDPOINT+'agent/upload/', uploadData, this.options)
      .subscribe(event => {
        window.location.reload();
      });
  }
}

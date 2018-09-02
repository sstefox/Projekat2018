import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../models/constants';
@Injectable()
export class AuthService {


    constructor(private http: HttpClient) {
    }

    attemptAuth(ussername: string, password: string) {
        const credentials = { username: ussername, password: password };
        console.log('attempAuth ::');
        return this.http.post(Constants.API_ENDPOINT+'token/generate-token', credentials);
    }

}

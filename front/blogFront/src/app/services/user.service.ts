import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8090/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUser() {

  }

  getUserBoard(): Observable<any> {
    return this.http.get(AUTH_API + 'user', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(AUTH_API + 'admin', { responseType: 'text' });
  }
}

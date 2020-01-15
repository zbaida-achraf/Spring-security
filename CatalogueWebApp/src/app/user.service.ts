import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public host: string = "http://localhost:8080";
  constructor(private http: HttpClient, private authService:AuthenticationService) { }

  getAllUsers() {
    return this.http.get(this.host + "/appUsers");
  }
}

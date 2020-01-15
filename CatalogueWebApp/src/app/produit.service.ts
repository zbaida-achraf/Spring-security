import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  public host: string = "http://localhost:8081";
  constructor(private http: HttpClient, private authService:AuthenticationService) { }

  getAllProducts() {
    return this.http.get(this.host + "/products");
  }
}

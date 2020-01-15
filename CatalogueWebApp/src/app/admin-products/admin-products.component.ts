import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import {ProduitService} from '../produit.service';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {

  products;
  constructor(private productService:ProduitService) { }

  ngOnInit() {
    this.productService.getAllProducts()
      .subscribe(data=>{
        this.products=data;
      },err=>{
        console.log(err);
      })
  }

}

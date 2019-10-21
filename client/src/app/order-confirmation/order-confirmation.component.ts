import { Component, OnInit } from '@angular/core';

import { ApiService } from '../core/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-confirmation',
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent implements OnInit {

  itemList:any=[];
  totalQuantity = 0;
  totalPrice = 0;
  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {
    
    this.loadData();
  }

  loadData() {
    
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data;
      for(var itemCount=0; itemCount<this.itemList.length; itemCount++){
        this.totalQuantity += this.itemList[itemCount].quantity;
        this.totalPrice += this.itemList[itemCount].quantity * this.itemList[itemCount].price;
      }
    });
  }

  placeOrder(){
    this.insertShopperOrder();
    this.router.navigate(['/order-received']) 
  }

  insertShopperOrder(){
    console.log("insertInShopperOrder start;");
    let j:any=[];
    let order = '{"totalAmount":'+this.totalPrice+', "status":"confirm", "userId":1}';
    j = JSON.parse(order); 

    var msg: any;
    console.log("inserting:\n");
    this.apiService.insertShopperOrder(j).subscribe(data => {
      msg = data;
    })
    console.log(msg);
    return 1;
  }

  insertOrder(){
    console.log("insertInShopperOrder start;");
    let cart;
    let j:any=[];
    for(var i = 0; i< this.itemList.length; i++){
    cart = '{"totalAmount":1, "status":"confirm", "userId":1}';
    j.push(JSON.parse(cart)); 
    }
    var msg: any;
    console.log("inserting:\n");
    this.apiService.updateCart(j).subscribe(data => {
      msg = data;
    })
    console.log(msg);
    return 1;
  }
}

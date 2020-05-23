import { Component, OnInit, Input } from '@angular/core';

import { ApiService } from '../core/api.service';
import { CategoryListComponent } from '../category-list/category-list.component'
import { Cart } from '../_models/cart-modal';
import { CartDetails } from '../_models/cart-detail-model';
import { resolve } from 'url';
import { Product } from '../_models/product-model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: Product[];
  itemList: any = [];
  temp = 0;
  ispaused = true;
  // Category:String="none";
  cat: CategoryListComponent;
  @Input() Category: string;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.loadData();
  }


  loadData() {
    this.apiService.getProducts().subscribe(data => { this.productList = data });
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });

  }

  addToCart(productId) {
    let result = this.getItemList(productId);

    alert(result)
    if (result == 0) {
      if (this.iterateList(productId) == 1) {
        this.insertInCart(productId);
      }
    }
    window.location.reload();
    // this.insertInCart(productId);
  }

  iterateList(productId) {
    for (var i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i].id == productId) {
        alert("item already added.");
        return 0;
      }
    }
    return 1;
  }

  insertInCart(productId) {
    console.log("insertInCart start;");
    let cart = '{"userId":1, "productId":' + productId + ', "quantity":1}';
    let c = JSON.parse(cart);
    console.log(c.productId);
    var msg: any;
    console.log("inserting:\n");
    this.apiService.insertCart(c).subscribe(data => {
      msg = data;
    })
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });
  }


// async someMethod(productName, productId) {
//   console.log("someMethod start", this.temp, this.itemList);
//   if (this.itemList.length == 0) {
//     console.log('itemList empty');
//     this.insertInCart(productId);
//     this.apiService.getCartDetails().subscribe(data => {
//       this.itemList = data
//     });
//   }
//   else {
//     for (var i = 0; i < this.itemList.length; i++) {
//       await new Promise(resolve => {
//         setTimeout(() => {
//           console.log('This is iteration ' + i, this.itemList[i].name, productName, this.itemList.length);
//           if (this.itemList[i].name == productName) {
//             console.log("method is returned;");
//             return 0;
//           }
//           resolve();
//         }, 1);
//       })
//     }

//     console.log('print me only after all iterations');
//     this.insertInCart(productId);
//     // alert(this.itemList.length);
//   }
// }

getItemList(productId) {
  if (this.itemList.length == 0) {
    console.log('itemList empty');
    this.insertInCart(productId);
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });
    return 1;
  }
  return 0;

}

}

import { Component, OnInit } from '@angular/core';

import { CategoryListComponent } from '../category-list/category-list.component'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  Category:String="none";
  cat:CategoryListComponent;
  // receivedChildMessage: string;
  
  constructor( ) { this.cat = new CategoryListComponent(); }

  ngOnInit() {
    this.Category = this.cat.getCategoryValue();
  }

  displayCounter(category){
    console.log("home", category);
    this.Category = category;
  }
}

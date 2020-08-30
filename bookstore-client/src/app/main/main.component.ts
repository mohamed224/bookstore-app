import { Component, OnInit , OnDestroy } from '@angular/core';
import {CartService} from "../cart/service/cart.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit , OnDestroy {

  numberOfItemsInCart:number =0;
  subscription : Subscription;
  constructor(private cartService: CartService) {
    this.subscription = this.cartService.numberOfItemsInCartObservable$.subscribe(
      data=>{
        this.numberOfItemsInCart = data;
      }
    )
  }

  ngOnInit(): void {

  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }


}

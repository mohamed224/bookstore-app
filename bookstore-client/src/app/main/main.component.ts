import { Component, OnInit , OnDestroy } from '@angular/core';
import {CartService} from "../cart/service/cart.service";
import {ContentComponent} from "../content/list-content/content.component";
import {CartObservableService} from "../service/cart-observable.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit , OnDestroy {

  numberOfItemsInCart:number =0;
  subscription : Subscription;
  constructor(private cartObservableService: CartObservableService) {
    this.subscription = this.cartObservableService.numberOfItemsInCartObservable$.subscribe(
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

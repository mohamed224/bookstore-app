import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartObservableService {

  private numberOfItemsInCartObservable = new BehaviorSubject<number>(0);
  numberOfItemsInCartObservable$ = this.numberOfItemsInCartObservable.asObservable();
  constructor() { }

  updateNumberOfItemInCartForNavBar(numberOfItemsInCart:number){
    this.numberOfItemsInCartObservable.next(numberOfItemsInCart);
  }
}

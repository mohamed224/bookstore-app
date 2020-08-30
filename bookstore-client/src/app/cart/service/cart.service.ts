import { Injectable } from '@angular/core';
import {OrderItem} from "../model/order-item";
import {Book} from "../../books/model/book";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private numberOfItemsInCartObservable = new BehaviorSubject<number>(0);
  numberOfItemsInCartObservable$ = this.numberOfItemsInCartObservable.asObservable();
  constructor() { }

  public addToCard(book : Book){
    let numberOfItemsInCart = this.getNumberOfItemsInCart() +1;
    let orderItem : OrderItem = new OrderItem();
    orderItem.book = book;
    let cartData = [];
    let data = localStorage.getItem('cart');
    if(data!=null){
      cartData = JSON.parse(data);
    }
    let _orderItem = cartData.find(orderItem=>{
      return orderItem.book.id== +book.id;
    })
    if(_orderItem==undefined){
      orderItem.price = book.price;
      orderItem.quantity = 1;
    }else{
      orderItem.quantity = 1 + _orderItem.quantity;
      orderItem.price = book.price*orderItem.quantity;
    }
    cartData = cartData.filter(orderItem1=> orderItem1.book.id !== orderItem.book.id);
    cartData.push(orderItem);
    this.storeCartDataInSession(cartData,numberOfItemsInCart.toString());

  }

  public getCartData()  {
    let cartData : OrderItem [] = [];
    let data = localStorage.getItem('cart');
    if(data!=null){
      cartData = JSON.parse(data);
    }
    return cartData;
  }

  public storeCartDataInSession(cartData: any[] , numberOfItemsInCart: string) {
      localStorage.setItem('numberOfItemsInCart', numberOfItemsInCart);
      localStorage.setItem('cart',JSON.stringify(cartData));
  }

  public getNumberOfItemsInCart(){
    let numberOfItemsInCart: number;
    numberOfItemsInCart =+localStorage.getItem('numberOfItemsInCart');
    return numberOfItemsInCart;
  }

  public clearBasket(){
    localStorage.removeItem('numberOfItemsInCart');
    localStorage.removeItem('cart');
  }

  public getTotalItemPriceInCart(){
    let totalPrice =0;
    this.getCartData().forEach(orderItem=>{
      totalPrice+=orderItem.price;
    })
    return totalPrice;
  }

  public removeItemFromCart(orderItem:OrderItem){
    let cartData : OrderItem [] = this.getCartData();
    cartData = cartData.filter(orderItem1=> orderItem1.book.id !== orderItem.book.id);
    let numberOfItemsInCart = this.getNumberOfItemsInCart()-orderItem.quantity;
    this.storeCartDataInSession(cartData,numberOfItemsInCart.toString());
  }

  updateNumberOfItemInCartForNavBar(numberOfItemsInCart:number){
    this.numberOfItemsInCartObservable.next(numberOfItemsInCart);
  }
}

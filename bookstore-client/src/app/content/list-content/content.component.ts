import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {GenericService} from "../../service/generic.service";
import {Book} from "../../books/model/book";
import {Operation} from "../../utils/operations";
import {CartService} from "../../cart/service/cart.service";
import {OrderItem} from "../../cart/model/order-item";
import {Router} from "@angular/router";
import {CartObservableService} from "../../service/cart-observable.service";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  books: Book [];
  cartBooks : any = [];
  numberOfItemsInCart:number =0;
  constructor(private genericService: GenericService , private cartService: CartService , private cartObservableService: CartObservableService) {
  }

  ngOnInit(): void {
    this.getBooks();
    this.cartBooks = this.cartService.getCartData();
    this.numberOfItemsInCart = this.cartService.getNumberOfItemsInCart();

  }

  getBooks() {
    this.genericService.callService(Operation.GET, 'books').subscribe(data => {
      this.books = data;
      this.books = this.genericService.setBookImgUrl(this.books);
    })
  }

  detailBook(id: number) {

  }

  addToCard(book: Book) {
    this.cartService.addToCard(book);
    this.numberOfItemsInCart = this.cartService.getNumberOfItemsInCart();
    this.cartObservableService.updateNumberOfItemInCartForNavBar(this.numberOfItemsInCart);

  }
}

import {Component, OnInit} from '@angular/core';
import {CartService} from "../service/cart.service";
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";
import {DeliveryMethod} from "../../utils/deliveryMethod";
import {CartObservableService} from "../../service/cart-observable.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartBooks : any = [];
  numberOfItemsInCart:number =0;
  totalItemPrice:number = 0;
  deliveryMethod: DeliveryMethod = DeliveryMethod.EXPRESS;
  constructor(private cartService: CartService , private genericService: GenericService , private cartObservableService: CartObservableService) {

  }

  ngOnInit(): void {
    this.getCartContentForInitialisationPurpose();
  }

  getCartContentForInitialisationPurpose(){
    this.cartBooks = this.cartService.getCartData();
    this.totalItemPrice = this.cartService.getTotalItemPriceInCart();
  }
  order() {
    this.genericService.callService(Operation.POST,'orders',this.cartBooks,`email=mdiaby00@gmail.com&deliveryMethod=${this.deliveryMethod}`,)
      .subscribe(data=>{
        alert("Votre commande a été bien enregistée.");
        this.cartService.clearBasket();
        this.getCartContentForInitialisationPurpose();

      },error => {
        console.log(error.error.text);
      })
  }

  removeItemFromCart(cartBook: any) {
    this.cartService.removeItemFromCart(cartBook);
    this.getCartContentForInitialisationPurpose();
    this.numberOfItemsInCart = this.cartService.getNumberOfItemsInCart();
    this.cartObservableService.updateNumberOfItemInCartForNavBar(this.numberOfItemsInCart);
  }

  deliveryMethodSelected(event: any) {
    this.deliveryMethod = event.target.value == 'E' ? DeliveryMethod.EXPRESS : DeliveryMethod.RELAY;
  }
}

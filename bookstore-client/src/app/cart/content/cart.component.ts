import {Component, OnInit} from '@angular/core';
import {CartService} from "../service/cart.service";
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";
import {DeliveryMethod} from "../../utils/deliveryMethod";
import {ClientService} from "../../client/service/client.service";
import {Router} from "@angular/router";


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
  constructor(private cartService: CartService , private genericService: GenericService,
              private clientService: ClientService,private router: Router) {

  }

  ngOnInit(): void {
    this.getCartContentForInitialisationPurpose();
  }

  getCartContentForInitialisationPurpose(){
    this.cartBooks = this.cartService.getCartData();
    this.totalItemPrice = this.cartService.getTotalItemPriceInCart();
  }
  order() {
    let email = this.clientService.getUserEmailInSession();
    if(email){
      this.genericService.callService(Operation.POST,'orders',this.cartBooks,`email=${email}&deliveryMethod=${this.deliveryMethod}`,)
        .subscribe(()=>{
          alert("Votre commande a été bien enregistée.");
          this.cartService.clearBasket();
        },() => {
        },()=>{
          this.getCartContentForInitialisationPurpose();
          this.numberOfItemsInCart = this.cartService.getNumberOfItemsInCart();
          this.cartService.updateNumberOfItemInCartForNavBar(this.numberOfItemsInCart);
        })
    }else{
      alert('Veuillez vous connecter pour pouvoir passer la commande.');
      this.router.navigateByUrl('main/client/login');
    }

  }

  removeItemFromCart(cartBook: any) {
    this.cartService.removeItemFromCart(cartBook);
    this.getCartContentForInitialisationPurpose();
    this.numberOfItemsInCart = this.cartService.getNumberOfItemsInCart();
    this.cartService.updateNumberOfItemInCartForNavBar(this.numberOfItemsInCart);
  }

  deliveryMethodSelected(event: any) {
    this.deliveryMethod = event.target.value == 'E' ? DeliveryMethod.EXPRESS : DeliveryMethod.RELAY;
  }
}

import {OrderItem} from "./order-item";
import {DeliveryMethod} from "../../utils/deliveryMethod";

export class Order {
  date : Date
  orderItems : OrderItem []
  client : any
  totalAmount : number
  deliveryMethod : DeliveryMethod
  cancelledOrder : boolean
}

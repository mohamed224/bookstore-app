import {Book} from "../../books/model/book";
import {Order} from "./order";

export class OrderItem {
  book : Book
  order : Order
  quantity : number
  price : number
}

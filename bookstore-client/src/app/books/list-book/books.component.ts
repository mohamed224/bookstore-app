import {Component, OnInit} from '@angular/core';
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";
import {Book} from "../model/book";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book [];

  constructor(private genericService: GenericService) {
  }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.genericService.callService(Operation.GET, 'books').subscribe(data => {
      this.books = data;
      this.books = this.setBookImgUrl(this.books);
    })
  }

  private setBookImgUrl(books: Book []) : Book []{
    const returnedBooks : Book [] =[];
    books.forEach(book => {
      book.imgUrl = 'data:image/jpeg;base64,' + book.picByte;
      returnedBooks.push(book);
    });
    return returnedBooks;
  }
}

import {Component, OnInit} from '@angular/core';
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";
import {Book} from "../model/book";
import {Router} from "@angular/router";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book [];

  constructor(private genericService: GenericService, private router: Router) {
  }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.genericService.callService(Operation.GET, 'books').subscribe(data => {
      this.books = data;
      this.books = this.genericService.setBookImgUrl(this.books);
    })
  }

  addBook() {
    this.router.navigateByUrl('book/add');
  }

  viewBook(id: number) {

  }

  editBook(id: number) {
    this.router.navigate(['book/edit/', id]);
  }

  deleteBook(book: Book) {
    this.genericService.callService(Operation.DELETE, 'books', book)
      .subscribe(() => {
        this.getBooks();
      });
  }


}

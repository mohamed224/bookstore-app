import {Component, OnInit} from '@angular/core';
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: any;

  constructor(private genericService: GenericService) {
  }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.genericService.callService(Operation.GET, 'books').subscribe(data => {
      this.books = data;
    })
  }

}

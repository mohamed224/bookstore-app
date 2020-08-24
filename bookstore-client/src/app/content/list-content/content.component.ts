import {Component, OnInit} from '@angular/core';
import {GenericService} from "../../service/generic.service";
import {Book} from "../../books/model/book";
import {Operation} from "../../utils/operations";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  books: Book [];
  constructor(private genericService: GenericService) {
  }

  ngOnInit(): void {
    this.getBooks();
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
    alert("lol");
  }
}

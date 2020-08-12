import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'bookstore-client';

  url:string = 'http://localhost:9090/books';
  books:any;
  constructor(private httpClient: HttpClient){

  }
  ngOnInit(){
    this.httpClient.get(this.url).subscribe(
      data=>{
        this.books = data;
      }
    )
  }


}

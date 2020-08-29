import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input()
  numberOfItemsInCart: number =0;
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  cart() {
    this.router.navigateByUrl('main/cart');
  }

  goHome() {
    this.router.navigateByUrl('main/content');
  }
}

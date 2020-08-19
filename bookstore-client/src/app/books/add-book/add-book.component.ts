import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Book} from "../model/book";
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  bookForm : FormGroup;
  selectedFile:any;
  book : Book;
  imgUrl : any;
  imgDisplayed : any;
  constructor(private fb : FormBuilder , private genericService: GenericService) {

  }

  ngOnInit() {
     this.createForm();
  }

  private createForm() {
    this.bookForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      author: ['', Validators.required],
      price: [0, Validators.required],
      quantity: [0, [Validators.required, Validators.compose([Validators.pattern('[0-9+ ]*')])]],
      available: [true],
      picByte: [null, Validators.required]
    });
  }

  save() {
    this.book = this.bookForm.getRawValue();
    this.book.picByte = null;
    const uploadData = new FormData();
    uploadData.append('imageFile',this.selectedFile , this.selectedFile.name);
    this.genericService.callService(Operation.POST, 'upload',uploadData,  '',{observe: 'response'}).
    subscribe(response=>{
      if(response.status==200){
        this.genericService.callService(Operation.POST,'books',this.book).
        subscribe(data=>{
          this.imgDisplayed = 'data:image/jpeg;base64,' + data.picByte;
        })
      }
    })

  }

  bookPicChange(event: any) {
    this.selectedFile = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);
    reader.onload = (e=>{
      this.imgUrl = reader.result;
    })

  }
}

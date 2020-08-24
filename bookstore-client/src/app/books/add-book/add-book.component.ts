import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Book} from "../model/book";
import {GenericService} from "../../service/generic.service";
import {Operation} from "../../utils/operations";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  bookForm: FormGroup;
  selectedFile: any;
  book: Book;
  imgUrl: any;
  isUpdateMode: boolean;
  id: number;

  constructor(private fb: FormBuilder, private genericService: GenericService, private activatedRoute: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.createForm();
    if (this.activatedRoute.component == AddBookComponent) {
      this.activatedRoute.params.subscribe(
        param => {
          this.id = +param.id || 0;
        }
      )
    }
    this.isUpdateMode = this.id > 0;
    this.initData();
  }

  getDataToUpdate() {
    const idData = {id: this.id};
    this.genericService.callService(Operation.GET, 'books', idData)
      .subscribe(data => {
        this.book = data;
        this.book.picByte = null;
        this.bookForm.patchValue(this.book);
      })
  }

  save() {
    if (!this.isUpdateMode) {
      this.saveOrUpdate();
    } else {
      this.saveOrUpdate(Operation.PUT)
    }

  }

  bookPicChange(event: any) {
    this.selectedFile = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);
    reader.onload = (() => {
      this.imgUrl = reader.result;
    })

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

  private saveOrUpdate(operationType?: Operation) {
    operationType = operationType ? Operation.PUT : Operation.POST;
    this.book = this.bookForm.getRawValue();
    if (this.isUpdateMode) {
      this.book.id = this.id;
    }
    this.book.picByte = null;
    const uploadData = new FormData();
    uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.genericService.callService(Operation.POST, 'upload', uploadData, '', {observe: 'response'}).subscribe(response => {
      if (response.status == 200) {
        this.genericService.callService(operationType, 'books', this.book).subscribe(() => {
        }, error => {

        }, () => {
          setTimeout(() => {
            this.router.navigateByUrl('book');
          }, 2000);
        })
      }
    })
  }

  private initData() {
    if (this.isUpdateMode) {
      this.getDataToUpdate();
    }
  }
}

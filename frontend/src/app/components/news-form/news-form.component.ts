import { Component } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent {

  postForm = this.formBuilder.group({
    header: ['', Validators.required],
    content: ['', Validators.required],
    author: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder) { }



  createPost() {
    console.log("trying to create post....")
  }
}

// TODO:
// 1). Service - for sending new news to backend
// 2). New form for news
  // a). all required fields
  // b). validation on that fields
  // c). gather fields values and push them to server

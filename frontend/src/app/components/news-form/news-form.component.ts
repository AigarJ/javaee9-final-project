import { Component } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {NewsFeedService} from "../../services/news-feed.service";
import {conditionallyCreateMapObjectLiteral} from "@angular/compiler/src/render3/view/util";
import {Post} from "../../models/post";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent {

  postForm = this.formBuilder.group({
    header: ['', Validators.required],
    content: ['',[Validators.required, Validators.minLength(3)]],
    author: ['', [Validators.required, Validators.minLength(3)]]
  })

  constructor(private formBuilder: FormBuilder,
              private newsService: NewsFeedService) { }



  // onButtonClicked() {
  //   console.log("trying to create post....")
  // }

  onFormSubmit() {
    console.log("on submitting whole form")
    console.log(`value from form: [${JSON.stringify(this.postForm.value)}]`)

    let post: Post = {
      id: null,
      author: this.postForm.value.author,
      content: this.postForm.value.content,
      header: this.postForm.value.header,
      creationTimestamp: null,
      updateTimestamp: null
    }
      this.newsService.createNewPost(post)

  }
}

// TODO:
// 1). Service - for sending new news to backend
// 2). New form for news
  // a). all required fields
  // b). validation on that fields
  // c). gather fields values and push them to server

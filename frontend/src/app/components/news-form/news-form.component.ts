import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

// TODO:
// 1). Service - for sending new news to backend
// 2). New form for news
  // a). all required fields
  // b). validation on that fields
  // c). gather fields values and push them to server

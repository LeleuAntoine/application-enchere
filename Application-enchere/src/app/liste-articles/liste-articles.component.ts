import { Component, OnInit } from '@angular/core';
import {CallerService} from "../caller.service";

@Component({
  selector: 'app-liste-articles',
  templateUrl: './liste-articles.component.html',
  styleUrls: ['./liste-articles.component.css']
})
export class ListeArticlesComponent implements OnInit {

  list: any;

  constructor(private caller: CallerService) { }

  ngOnInit(): void {
  }

  ListArticle() {
    return this.caller.getListArticle().subscribe(data => {
      console.log(data);
      this.list = data
    }, err => {
      console.log(err);
    });
  }
}

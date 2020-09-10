import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CallerService} from "../../caller.service";

@Component({
  selector: 'app-nouvelarticle',
  templateUrl: './nouvelarticle.component.html',
  styleUrls: ['./nouvelarticle.component.css']
})
export class NouvelarticleComponent implements OnInit {

  ArticleForm: FormGroup;
  list: any;

  constructor(private fb: FormBuilder, private caller: CallerService) {
  }

  ngOnInit(): void {
    this.ArticleForm = this.fb.group({
      article: [],
      description: [],
      Categorie: [],
      miseAPrix: [],
      debutEnchere: [],
      finEnchere: [],
      rue: [],
      codePostal: [],
      ville: []
    })
  }

  /**
   * Ajoute un article
   * */
  postAddArticle(form: any) {
    console.log(form)
    this.caller.postAddArticle(form).subscribe(data => {
      console.log(data);
    }, err => {
      console.log(err);
    });
  }

  /**
   * Converti en Json le formulaire
   * */
  submit(articleForm: FormGroup) {
    articleForm = this.ArticleForm.getRawValue();
    this.postAddArticle(JSON.stringify(articleForm));
  }

  /**
   * retourne la liste des categorie enregistré en BDD
   * */
  ListCategory() {
    return this.caller.getListCategories().subscribe(data => {
      console.log(data);
      this.list = data
    }, err => {
      console.log(err);
    });
  }
}

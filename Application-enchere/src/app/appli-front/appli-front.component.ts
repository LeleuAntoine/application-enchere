import {Component, Input, OnInit} from '@angular/core';
import {CallerService} from "../caller.service";
import {SignupComponent} from "../auth/signup/signup.component";


@Component({
  selector: 'app-appli-front',
  templateUrl: './appli-front.component.html',
  styleUrls: ['./appli-front.component.css']
})
export class AppliFrontComponent implements OnInit {

  private data: any;
  json: any;

  constructor(public caller: CallerService) {
  }

  ngOnInit(): void {
  }

  DeleteUser() {
    this.json = {};
    this.caller.deleteUser(this.json).subscribe(data => {
      this.data = data;
      console.log('this.data', this.data);
    })
  }

  AddCategory() {
    this.json = {
      "libelle": "Test"
    };
    this.caller.postAddCategory(this.json).subscribe(data => {
      this.data = data;
      console.log('this.data', this.data);
    })
  }

  UpdateUser() {
    this.json = {
      "userId": "1023",
      "email": "ant.82@hotmail.fr",
      "telephone": "0759",
      "prenom": "Antoine",
      "nom": "Leleu",
      "pseudo": "Adalrik",
      "rue": "la rue",
      "codePostal": "34170",
      "ville": "Lille",
      "motDePasse": "456123",
      "credit": "100",
      "administrateur": "1"
    };
    this.caller.putUpdateUser(this.json).subscribe(data => {
      this.data = data;
      console.log('this.data', this.data);
    })
  }
}

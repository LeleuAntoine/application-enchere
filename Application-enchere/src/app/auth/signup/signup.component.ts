import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CallerService} from "../../caller.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signup: FormGroup;

  constructor(private fb: FormBuilder, private caller: CallerService) {
  }

  ngOnInit(): void {
    this.signup = this.fb.group({
      pseudo: [],
      nom: [],
      prenom: [],
      email: [],
      telephone: [],
      rue: [],
      codePostal: [],
      ville: [],
      motDePasse: []
    })
  }

  /**
   * Ajoute un Utilisateur en BDD
   * */
  postAddUser(form: any) {
    console.log(form)
    this.caller.postAddUser(form).subscribe(data => {
      console.log(data);
    }, err => {
      console.log(err);
    });
  }

  /**
   * Converti en Json le formulaire
   * */
  submit(loginForm: FormGroup) {
    this.postAddUser(JSON.stringify(this.signup.getRawValue()));
  }
}

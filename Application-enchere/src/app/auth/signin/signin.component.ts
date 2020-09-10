import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CallerService} from "../../caller.service";
import {AuthService} from "../../services/auth.service";
import {Headers} from "@angular/http";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  signin: FormGroup;

  constructor(private fb: FormBuilder, private caller: CallerService,private authService:AuthService) {
  }

  ngOnInit(): void {
    this.signin = this.fb.group({
      pseudo: [],
      motDePasse: []
    })
  }

  /**
   * Envoie un formulaire de connexion
   * */
  postSignin(form: any) {
    this.caller.postSignin(form).subscribe(data => {
      // let jwtToken=data.headers.get('Authorization');
      // this.authService.saveTokken(jwtToken);
      // console.log("jwtToken " + jwtToken.toString())
    }, err => {
      console.log(err);
    });
  }

  /**
   * Converti en Json le formulaire
   * */
  submit(loginForm: FormGroup) {
    loginForm = this.signin.getRawValue();
    this.postSignin(JSON.stringify(loginForm));
  }
}

import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthService} from "./services/auth.service";

const options = {headers: {'Content-Type': 'application/json','authorization':'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZXN0IiwiZXhwIjoxNjAwNTI1MDI5fQ.tJdsfcLAye6G-8NNfdzSswEpECnIwjGfhWot2WOVF3edbcZ42W4nOr7jMyyTDR1vM0fLpArquYMlUggeWLfKYg'}};
// , 'Authorization':this.authService.loadToken()
@Injectable({
  providedIn: 'root'
})
export class CallerService {


  constructor(private http: HttpClient,private authService:AuthService ) {
  }

  deleteUser(json: any) {
    return this.http.delete<any>('http://localhost:8080/enchere/users/deleteUser/{userId}', json);
  }

  // getArticle(){
  //   return this.http.get<any>()
  // }

  getListCategories() {
    return this.http.get<any>('http://localhost:8080/enchere/categories/listCategories', options);
  }

  getListArticle() {
    return this.http.get<any>('http://localhost:8080/enchere/pages', options);
  }

  postAddCategory(json: any) {
    return this.http.post<any>('http://localhost:8080/enchere/categories/addCategorie', json, options);
  }

  putUpdateUser(json: any) {
    return this.http.put<any>('http://localhost:8080/enchere/users/updateUser', json, options);
  }

  /**
   * Ajoute un article
   * @param json
   * */
  postAddArticle(json: any) {
    return this.http.post<any>('http://localhost:8080/enchere/addArticles', json, options);
  }

  /**
   * Ajoute Utilisateur en BDD
   * @param json
   * */
  postAddUser(json: any) {
    console.log("caller " + json)
    return this.http.post<any>('http://localhost:8080/users/sign-up', json, options
    );
  }

  /**
   * Envoie un formulaire de connexion
   * @param json
   * */
  postSignin(json: any) {
    return this.http.post<any>('http://localhost:8080/login', json, options);
  }
}

// enchere/users/sign-up

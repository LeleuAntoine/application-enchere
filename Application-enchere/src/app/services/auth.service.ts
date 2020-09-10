import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private host: string = "http://localhost:8080";
  private jwtToken: string;

  // private roles:Array<any>=[];


  constructor(private http: HttpClient) {
  }

  // login(user) {
  //   return this.http.post(this.host + "login", user, {observe: 'response'});
  // }
  //
  // register(user) {
  //   return this.http.post(this.host + "/users", user);
  // }

  saveTokken(jwtToken) {
    this.jwtToken = jwtToken;
    localStorage.setItem("id_token", jwtToken);
    // let jwtHelper = new  JwtHelper();
    // this.roles=jwtHelper.decodeToken(this.jwtToken).roles;
  }

  // getTask() {
  //   if (this.jwtToken == null) {
  //     this.loadToken();
  //   }
  //   return this.http.get(this.host + "/tasks", {headers: new HttpHeaders({'authorization': this.jwtToken})})
  // }
  //
  // saveTask(task) {
  //   let headers = new HttpHeaders();
  //   headers.append('authorization', this.jwtToken);
  //   return this.http.post(this.host + "/tasks", task, {headers: new HttpHeaders({'authorization': this.jwtToken})})
  // }

  loadToken() {
    this.jwtToken = localStorage.getItem("id_token");
    return this.jwtToken;
  }

  logout() {
    localStorage.removeItem('id_token');
  }

  // isAdmin() {
  //   for (let r of this.roles) {
  //     if (r.authority == 'ADMIN') return true;
  //   }
  //   return false;
  // }
}

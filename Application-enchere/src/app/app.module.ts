import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppliFrontComponent} from './appli-front/appli-front.component';
import {HttpClientModule} from "@angular/common/http";
import {SignupComponent} from './auth/signup/signup.component';
import {SigninComponent} from './auth/signin/signin.component';
import {ArticleComponent} from './liste-articles/article/article.component';
import {NouvelarticleComponent} from './liste-articles/nouvelarticle/nouvelarticle.component';
import {HeaderComponent} from './header/header.component';
import {AuthService} from "./services/auth.service";
import {ArticlesService} from "./services/articles.service";
import {AuthGuardService} from "./services/auth-guard.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import {ListeArticlesComponent} from "./liste-articles/liste-articles.component";
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {InterceptorService} from "./interceptor.service";



const appRoutes: Routes = [
  {path: 'auth/signup', component: SignupComponent},
  {path: 'auth/signin', component: SigninComponent},
  {path: 'articles', component: ListeArticlesComponent},
  {path: 'articles/new', component: NouvelarticleComponent},
  {path: 'articles/view/:id', component: ArticleComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    AppliFrontComponent,
    SignupComponent,
    SigninComponent,
    ListeArticlesComponent,
    ArticleComponent,
    NouvelarticleComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorService,
      multi: true
    },
    AuthService,
    ArticlesService,
    AuthGuardService
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}

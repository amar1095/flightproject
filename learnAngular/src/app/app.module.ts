import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { AboutComponent } from './about/about.component';
import { UserformComponent } from './component/userform/userform.component';
import { NavbarComponent } from './component/Navbar/navbar.component';
import { CounterComponent } from './componenet/counter/counter.component';
import { EllipsisPipe } from './ellipsis.pipe';
import { ValidformComponent } from './validform/validform.component';


@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    NavbarComponent,
    AboutComponent,
    CounterComponent,
    EllipsisPipe,
    ValidformComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
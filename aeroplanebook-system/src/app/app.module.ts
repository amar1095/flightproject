import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightDeatilsComponent } from './flight-deatils/flight-deatils.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { FormsModule  } from "@angular/forms";
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { HomeComponent } from './home/home.component';
import { AdminFormComponent } from './admin-form/admin-form.component';
import { UserBookComponent } from './user-book/user-book.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { SearchComponent } from './search/search.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2OrderModule } from 'ng2-order-pipe';
import {NgxPaginationModule} from 'ngx-pagination';
import { AboutComponent } from './about/about.component'; // <-- import the module




@NgModule({
  declarations: [
    AppComponent,
    FlightDeatilsComponent,
    CreateFlightComponent,
    UpdateFlightComponent,
    HomeComponent,
    AdminFormComponent,
    UserBookComponent,
    BookDetailsComponent,
    SearchComponent,
    AboutComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    NgxPaginationModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

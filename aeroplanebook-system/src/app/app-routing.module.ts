import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminFormComponent } from './admin-form/admin-form.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { FlightDeatilsComponent } from './flight-deatils/flight-deatils.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { UserBookComponent } from './user-book/user-book.component';


const routes: Routes = [
  {path: 'allflight', component: FlightDeatilsComponent},
  {path: '', redirectTo: 'allflight', pathMatch: 'full'},
  {path: 'addflight', component: CreateFlightComponent},
  {path: 'updateFlight/:flightnumber', component: UpdateFlightComponent},
  {path: 'homepage', component: HomeComponent},
  {path:'validform', component:AdminFormComponent},
  {path:'addbook', component:UserBookComponent},
  {path:'homedetails', component:AboutComponent},

  {path:'bookdetails', component:BookDetailsComponent},
  {path:'searchdetails', component:SearchComponent}






 




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

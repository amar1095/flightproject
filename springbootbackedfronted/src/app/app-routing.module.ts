import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { HomeComponent } from './home/home.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path: 'allemployee', component: EmployeeListComponent},
  {path: 'employee', component: CreateEmployeeComponent},
  {path: '', redirectTo: 'homePage', pathMatch: 'full'},
  {path: 'updateemployee/:id', component: UpdateEmployeeComponent},
  {path: 'aboutpage', component: AboutComponent},
  {path: 'homePage', component: HomeComponent},
  {path: 'thankuPage', component: ThankyouComponent}




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bookticket } from '../bookticket';
import { UserService } from '../user.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  flights: Bookticket[];
  constructor(private flightService: UserService,private router : Router){}
  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees(){
    this.flightService.getEmployeeList().subscribe(data =>{
      console.log(data);
      this.flights=data;
    });
  }


  deleteEmployee(id: number){
    console.log("========flightNumber=====flightNumber======"+id);

    this.flightService.deleteEmployee(id).subscribe( data => {
      console.log("==================="+data);
      this.getEmployees();
    })
  }

}

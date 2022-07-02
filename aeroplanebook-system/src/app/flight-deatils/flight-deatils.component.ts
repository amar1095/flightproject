import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-deatils',
  templateUrl: './flight-deatils.component.html',
  styleUrls: ['./flight-deatils.component.css']
})
export class FlightDeatilsComponent implements OnInit {
  flights: Flight[];
  constructor(private flightService: FlightService,private router : Router){}
  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees(){
    this.flightService.getEmployeeList().subscribe(data =>{
      console.log(data);
      this.flights=data;
    });
  }

  updateEmployee(flightNumber: number){
    this.router.navigate(['updateFlight', flightNumber]);
  }

  deleteEmployee(flightNumber: number){
    console.log("========flightNumber=====flightNumber======"+flightNumber);

    this.flightService.deleteEmployee(flightNumber).subscribe( data => {
      console.log("==================="+data);
      this.getEmployees();
    })
  }

}

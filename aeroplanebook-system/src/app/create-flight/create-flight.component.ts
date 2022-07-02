import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-create-flight',
  templateUrl: './create-flight.component.html',
  styleUrls: ['./create-flight.component.css']
})
export class CreateFlightComponent implements OnInit {

  flight: Flight = new Flight();
  constructor(private flightService: FlightService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
   this.flightService.createFlight(this.flight).subscribe( data =>{
    console.log(data);
     this.goToEmployeeList();
   },
    error => console.log(error));
  } 

  goToEmployeeList(){
    this.router.navigate(['/allflight']);
  }
  
  onSubmit(){
    console.log(this.flight);
    this.saveEmployee();
  }

}

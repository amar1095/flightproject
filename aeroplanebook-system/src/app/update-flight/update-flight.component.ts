import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {

  submitted = false;
  
  flightNumber: number;
  flight: Flight = new Flight();
  constructor(private flightService: FlightService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.flightNumber = this.route.snapshot.params['flightNumber'];
   
    console.log("========flightNumber====flight======="+this.flightNumber);

      this.flightService.getEmployeeById(this.flightNumber).subscribe(data => {
        this.flight = data;
      }, error => console.log(error));
    
   
  }

  onSubmit(){
    this.submitted = true;
    this.flightService.updateEmployee(this.flightNumber, this.flight).subscribe( data =>{
      this.goToEmployeeList();
    }
    , error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/allflight']);
  }

}

import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-admin-form',
  templateUrl: './admin-form.component.html',
  styleUrls: ['./admin-form.component.css']
})
export class AdminFormComponent implements OnInit {
 
  flight: Flight = new Flight();
  constructor(private flightService: FlightService,
    private router: Router) { }
  onsubmit(data: any){

    console.warn(data);
    this.router.navigate(['/homepage']);

  }

  ngOnInit(): void {
  }

}

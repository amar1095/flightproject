import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bookticket } from '../bookticket';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-book',
  templateUrl: './user-book.component.html',
  styleUrls: ['./user-book.component.css']
})
export class UserBookComponent implements OnInit {

  flight: Bookticket = new Bookticket();
  constructor(private flightService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
   this.flightService.createBookTicket(this.flight).subscribe( data =>{
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

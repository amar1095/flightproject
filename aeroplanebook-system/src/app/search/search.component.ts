import { Component, OnInit } from '@angular/core';
import { SerachService } from '../serach.service';
import { Users } from '../users';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
users: Users[]=[];
userFirstName: any;
  constructor(public rs: SerachService 
    ) { }

  ngOnInit(): void {
    this.rs.getUsers().subscribe((response) => {
    this.users=response;
  })
}
Search(){
  console.log("===="+this.userFirstName)
  if(this.userFirstName == " "){
    this.ngOnInit();
  }else{
    this.users=this.users.filter(res =>{
      return res.userFirstName.toLocaleLowerCase().match(this.userFirstName.toLocaleLowerCase());
    });

  }
}

}

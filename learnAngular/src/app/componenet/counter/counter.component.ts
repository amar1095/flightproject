import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

  product = {
    name: "Samsung galaxy s22",
    color:"pearl white",
    price: 100000,
    launchedOn: Date.now()
  }

  constructor() { }

  ngOnInit(): void {
  }

}

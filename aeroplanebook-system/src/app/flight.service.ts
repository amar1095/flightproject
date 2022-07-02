import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  private BaseUrl = "http://localhost:9888/searchAllFlights";
  private Base_Url=  "http://localhost:9888/addFlight";
  private Base_Url1=  "http://localhost:9888/updateFlight";
  private Base_Url2=  "http://localhost:9888/deleteFlight";
  private Base_Url5=  "http://localhost:9888/getFlightsByNumber";




  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Flight[]> {
    console.log('${this.BaseUrl}');
    return this.httpClient.get<Flight[]>(`${this.BaseUrl}`);
  }

  createFlight(flight: Flight): Observable<Object> {
    return this.httpClient.post(`${this.Base_Url}`, flight);
  }

  getEmployeeById(flightNumber: number): Observable<Flight> {
    return this.httpClient.get<Flight>(`${this.Base_Url5}/${flightNumber}`);
  }

  updateEmployee(flightNumber: number, flight: Flight): Observable<Object> {
    console.log("========flightNumber==========="+flightNumber);
    return this.httpClient.put(`${this.Base_Url1}/${flightNumber}`, flight);
  }

  deleteEmployee(flightNumber: number): Observable<Object> {

    return this.httpClient.delete(`${this.Base_Url2}/${flightNumber}`);
  }
}

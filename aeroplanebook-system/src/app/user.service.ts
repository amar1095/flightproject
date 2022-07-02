import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bookticket } from './bookticket';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private Base_Url=  "http://localhost:9889/user/bookFlight";
  private BaseUrl=  "http://localhost:9889/user/getAllBookFlight";
  private BaseUrl3=  "http://localhost:9889/user/cancelFlight";




  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Bookticket[]> {
    console.log('${this.BaseUrl}');
    return this.httpClient.get<Bookticket[]>(`${this.BaseUrl}`);
  }

  createBookTicket(book: Bookticket): Observable<Object> {
    return this.httpClient.post(`${this.Base_Url}`, book);
  }

  deleteEmployee(id: number): Observable<Object> {

    return this.httpClient.delete(`${this.BaseUrl3}/${id}`);
  }
}

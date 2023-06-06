import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private apiUrl = 'http://localhost:9000/events';

  constructor(private http: HttpClient) {}

  getAllEvent(){
    return this.http.get(`${this.apiUrl}`);
  }
}

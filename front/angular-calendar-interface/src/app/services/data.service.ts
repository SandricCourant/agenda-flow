import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:9000/api/user/'

@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private http: HttpClient) {}

  getAllEvent(): Observable<any>{
    return this.http.get(API_URL + 'events',  { responseType: 'json'});
  }
}

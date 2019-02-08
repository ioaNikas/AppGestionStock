import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fourniture } from '../models/Fourniture';

@Injectable({
  providedIn: 'root'
})
export class FournitureService {

  private baseUrl = 'http://localhost:8080/api/fournitures';

  constructor(private http: HttpClient) { }

  getAllFournitures(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  postFourniture(fourniture : Fourniture): Observable<Object> {
    return this.http.post(`${this.baseUrl}/creer`, fourniture);
  }

  deleteFourniture(id : number) : Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  updateFourniture(id: number, fourniture : Fourniture): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, fourniture)
  }
}
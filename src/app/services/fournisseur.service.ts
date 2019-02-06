import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fournisseur } from '../models/Fournisseur';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {

  private baseUrl = 'http://localhost:8080/api/fournisseurs';

  constructor(private http: HttpClient) { }

  getAllFournisseurs(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  postFournisseur(fournisseur : Fournisseur): Observable<Object> {
    return this.http.post(`${this.baseUrl}/creer`, fournisseur);
  }

  deleteFournisseur(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  updateFournisseur(id: number, fournisseur : Fournisseur): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, fournisseur)
  }
}
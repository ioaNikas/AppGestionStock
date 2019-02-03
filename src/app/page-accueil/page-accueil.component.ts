import { Component, OnInit } from '@angular/core';
import { Fourniture } from '../models/Fourniture';
import { FournitureService } from '../services/fournitureService';

@Component({
  selector: 'app-page-accueil',
  templateUrl: './page-accueil.component.html',
  styleUrls: ['./page-accueil.component.css']
})
export class PageAccueilComponent implements OnInit {

  fournitures : Fourniture[];

  constructor(private fournitureService : FournitureService) { }

  ngOnInit() {
    this.fournitureService.getAllFournitures()
      .subscribe(data => this.fournitures = data);
  }

}

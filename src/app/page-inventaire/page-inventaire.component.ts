import { Component, OnInit } from '@angular/core';
import { Fourniture } from '../models/Fourniture';
import { FournitureService } from '../services/fournitureService';

@Component({
  selector: 'app-page-inventaire',
  templateUrl: './page-inventaire.component.html',
  styleUrls: ['./page-inventaire.component.css']
})
export class PageInventaireComponent implements OnInit {

  fournitures : Fourniture[];

  constructor(private fournitureService : FournitureService) { }

  ngOnInit() {
    this.fournitureService.getAllFournitures()
      .subscribe(data => this.fournitures = data);
  }

}

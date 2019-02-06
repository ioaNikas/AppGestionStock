import { Component, OnInit } from '@angular/core';
import { Fourniture } from '../models/Fourniture';
import { FournitureService } from '../services/fourniture.service';

@Component({
  selector: 'app-page-inventaire',
  templateUrl: './page-inventaire.component.html',
  styleUrls: ['./page-inventaire.component.css']
})
export class PageInventaireComponent implements OnInit {

  public fournitures : Fourniture[];

  constructor(private fournitureService : FournitureService) { }

  ngOnInit() {
    this.fournitureService.getAllFournitures()
      .subscribe(data => this.fournitures = data);
  }

}

import { Component, OnInit } from '@angular/core';
import { Fourniture } from '../models/Fourniture';
import { FournitureService } from '../services/fournitureService';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-modifier-stock',
  templateUrl: './modifier-stock.component.html',
  styleUrls: ['./modifier-stock.component.css']
})
export class ModifierStockComponent implements OnInit {
  
  public formUpdate: FormGroup;
  public fournitures : Fourniture[];

  constructor(private fournitureService : FournitureService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.fournitureService.getAllFournitures()
      .subscribe(data => {this.fournitures = data;
        this.formUpdate.setValue({
          nom = this.fourniures[i].nom,
          
        })})
        
  }

}

import { Component, OnInit } from '@angular/core';
import { Fourniture } from '../models/Fourniture';
import { FournitureService } from '../services/fourniture.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-modifier-stock',
  templateUrl: './modifier-stock.component.html',
  styleUrls: ['./modifier-stock.component.css']
})
export class ModifierStockComponent implements OnInit {

  public formCreate: FormGroup;
  public fournitures: Fourniture[];
  public submitted: boolean = false;

  constructor(private fournitureService: FournitureService, private fb: FormBuilder) {

    this.formCreate = this.addFourniture();

  }

  get f() { return this.formCreate.controls; }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.fournitureService.getAllFournitures()
      .subscribe(data => this.fournitures = data)
  }

  addFourniture(): FormGroup {
    return this.fb.group(
      {
        nom: [
          null
        ],
        quantite: [
          null
        ],
        prix: [
          null,
        ],
        fournisseur: [
          null,
        ],
        seuilCritique: [
          null
        ]
      },
    );
  }

  onSubmit() {
    const fourniture: Fourniture = this.formCreate.value;
    this.fournitureService.postFourniture(fourniture)
      .subscribe(data => {this.submitted = true;
                          console.log(data)})
  }
}
import { Component, OnInit } from '@angular/core';
import { Fourniture } from '../models/Fourniture';
import { FournitureService } from '../services/fourniture.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FournisseurService } from '../services/fournisseur.service';
import { Fournisseur } from '../models/Fournisseur';

@Component({
  selector: 'app-page-inventaire',
  templateUrl: './page-inventaire.component.html',
  styleUrls: ['./page-inventaire.component.css']
})
export class PageInventaireComponent implements OnInit {

  public formCreate: FormGroup;
  public formUpdate: FormGroup;
  public fournitures: Fourniture[];
  public fournisseurs: Fournisseur[];
  public fourniture: Fourniture;
  public submitted: boolean = false;
  public modification: boolean = false;
  public errorMessage: boolean = false;

  constructor(private fournitureService: FournitureService,
    private fournisseurService: FournisseurService,
    private fb: FormBuilder) {

    this.formCreate = this.fb.group(
      {
        nom: [null, Validators.required],
        quantite: [null, Validators.required],
        prix: [null],
        fournisseur: [null, Validators.required],
        seuilCritique: [null, Validators.required]
      }
    );
    this.formUpdate = this.formCreate;
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.fournitureService.getAllFournitures()
      .subscribe(data => this.fournitures = data);
    this.fournisseurService.getAllFournisseurs()
      .subscribe(data => this.fournisseurs = data);
  }

  onSubmit() {
    const fourniture: Fourniture = this.formCreate.value;
    this.fournitureService.postFourniture(fourniture)
      .subscribe(data => {
        this.submitted = true;
        console.log(data)
      },
        error => this.errorMessage = true)
    window.location.reload();
  }

  onUpdate() {
    const fourniture: Fourniture = this.formUpdate.value;
      this.fournitureService.updateFourniture(this.fourniture.id, fourniture)
        .subscribe(data => console.log(data));
      window.location.reload();
  }

  deleteFourniture(i: number) { // TODO: fonctionne mais renvoi une erreur dans la console
    this.fournitureService.deleteFourniture(i)
      .subscribe(data => console.log(data));
    window.location.reload();
  }

  fenetreModification(fourniture: Fourniture) {
    this.fourniture = fourniture;
    this.modification = true;
    this.formUpdate.setValue({
      nom: this.fourniture.nom,
      quantite: this.fourniture.quantite,
      prix: this.fourniture.prix,
      fournisseur: this.fourniture.fournisseur,
      seuilCritique: this.fourniture.seuilCritique
    })
    window.scrollTo(0, document.body.scrollHeight);
  }

  retour() {
    this.modification = false;
    let scrollToTop = window.setInterval(() => {
      let pos = window.pageYOffset;
      if (pos > 0) {
        window.scrollTo(0, pos - 20);
      } else {
        window.clearInterval(scrollToTop);
      }
    }, 16);
  }

}

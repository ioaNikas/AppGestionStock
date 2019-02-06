import { Component, OnInit } from '@angular/core';
import { FournisseurService } from '../services/fournisseur.service';
import { Fournisseur } from '../models/Fournisseur';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-liste-fournisseurs',
  templateUrl: './liste-fournisseurs.component.html',
  styleUrls: ['./liste-fournisseurs.component.css']
})
export class ListeFournisseursComponent implements OnInit {

  public formCreate: FormGroup;
  public formUpdate: FormGroup;
  public fournisseurs : Fournisseur[];
  public submitted: boolean = false;
  public errorMessage: boolean = false;
  public modification: boolean = false;
  public fournisseur: Fournisseur;

  constructor(private fournisseurService : FournisseurService, private fb : FormBuilder) { 

    this.formCreate = this.formFournisseur();
    this.formUpdate = this.formFournisseur();

  }

  get f() { return this.formCreate.controls; }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.fournisseurService.getAllFournisseurs()
      .subscribe(data => this.fournisseurs = data);
  }

  formFournisseur(): FormGroup {
    return this.fb.group(
      {
        raisonSociale: [
          null
        ],
        adresse: [
          null
        ],
        tel: [
          null
        ],
        mail: [
          null
        ]
      }
    );
  }

  deleteFournisseur(i) {
    this.fournisseurService.deleteFournisseur(i).subscribe(data => console.log(data)); //fonctionne mais produit une erreur dans la console
    window.location.reload();
  }
  
  fenetreModification(fournisseur) {
    this.fournisseur = fournisseur;
    this.modification = true;
  }

  onSubmit() {
    const fournisseur : Fournisseur = this.formCreate.value;
    this.fournisseurService.postFournisseur(fournisseur)
      .subscribe(data => {this.submitted = true;
                          console.log(data)},
                          error => this.errorMessage = true)
    window.location.reload();
  }

  onUpdate() {
    const fournisseur : Fournisseur = this.formUpdate.value;
     if (fournisseur.raisonSociale != null && fournisseur.adresse != null && fournisseur.tel != null && fournisseur.mail != null) {
    this.fournisseurService.updateFournisseur(this.fournisseur.id, fournisseur)
      .subscribe(data => console.log(data));
      window.location.reload();
    } else {
      this.errorMessage = true;
    }
  }
}

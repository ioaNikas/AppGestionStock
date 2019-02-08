import { Component, OnInit } from '@angular/core';
import { FournisseurService } from '../services/fournisseur.service';
import { Fournisseur } from '../models/Fournisseur';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-liste-fournisseurs',
  templateUrl: './liste-fournisseurs.component.html',
  styleUrls: ['./liste-fournisseurs.component.css']
})
export class ListeFournisseursComponent implements OnInit {

  public formCreate: FormGroup;
  public formUpdate: FormGroup;
  public fournisseurs: Fournisseur[];
  public submitted: boolean = false;
  public errorMessage: boolean = false;
  public modification: boolean = false;
  public fournisseur: Fournisseur;

  constructor(private fournisseurService: FournisseurService,
    private fb: FormBuilder) {

    this.formCreate = this.fb.group(
      {
        raisonSociale: [null, Validators.required],
        adresse: [null, Validators.required],
        tel: [null, Validators.required],
        mail: [null, [Validators.required, Validators.email]]
      }
    );
    this.formUpdate = this.formCreate;

  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.fournisseurService.getAllFournisseurs()
      .subscribe(data => this.fournisseurs = data);
  }

  deleteFournisseur(i: number) {
    this.fournisseurService.deleteFournisseur(i)
      .subscribe(data => console.log(data));
    window.location.reload();
  }

  fenetreModification(fournisseur) {
    this.fournisseur = fournisseur;
    this.modification = true;
    this.formUpdate.setValue({
      raisonSociale: this.fournisseur.raisonSociale,
      adresse: this.fournisseur.adresse,
      tel: this.fournisseur.tel,
      mail: this.fournisseur.mail
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

  onSubmit() {
    const fournisseur: Fournisseur = this.formCreate.value;
    this.fournisseurService.postFournisseur(fournisseur)
      .subscribe(data => {
        this.submitted = true;
        console.log(data)
      },
        error => this.errorMessage = true)
    window.location.reload();
  }

  onUpdate() {
    const fournisseur: Fournisseur = this.formUpdate.value;
      this.fournisseurService.updateFournisseur(this.fournisseur.id, fournisseur)
        .subscribe(data => console.log(data));
      window.location.reload();
  }
}

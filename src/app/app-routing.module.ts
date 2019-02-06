import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageAccueilComponent } from './page-accueil/page-accueil.component';
import { PageInventaireComponent } from './page-inventaire/page-inventaire.component';
import { PageBDCComponent } from './page-bdc/page-bdc.component';
import { ModifierStockComponent } from './modifier-stock/modifier-stock.component';
import { ListeFournisseursComponent } from './liste-fournisseurs/liste-fournisseurs.component';
import { ModifierFournisseurComponent } from './modifier-fournisseur/modifier-fournisseur.component';

const routes: Routes = [
  {path: "accueil", component: PageAccueilComponent, children: [
    {path: "inventaire", component: PageInventaireComponent},
    {path: "boncommande", component: PageBDCComponent},
    {path: "modifier-stock", component: ModifierStockComponent},
    {path: "liste-fournisseurs", component: ListeFournisseursComponent, children : [
      {path: "modifier-fournisseur/:id", component: ModifierFournisseurComponent}
    ]}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
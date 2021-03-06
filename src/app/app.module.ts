import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageLoginComponent } from './page-login/page-login.component';
import { PageAccueilComponent } from './page-accueil/page-accueil.component';
import { PageInventaireComponent } from './page-inventaire/page-inventaire.component';
import { PageBDCComponent } from './page-bdc/page-bdc.component';
import { ModifierStockComponent } from './modifier-stock/modifier-stock.component';
import { ListeFournisseursComponent } from './liste-fournisseurs/liste-fournisseurs.component';
import { ModifierFournisseurComponent } from './modifier-fournisseur/modifier-fournisseur.component';

@NgModule({
  declarations: [
    AppComponent,
    PageLoginComponent,
    PageAccueilComponent,
    PageInventaireComponent,
    PageBDCComponent,
    ModifierStockComponent,
    ListeFournisseursComponent,
    ModifierFournisseurComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

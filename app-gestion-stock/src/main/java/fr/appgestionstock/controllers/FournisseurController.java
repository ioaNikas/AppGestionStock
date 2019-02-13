package fr.appgestionstock.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.appgestionstock.messages.request.FournisseurForm;
import fr.appgestionstock.models.Fournisseur;
import fr.appgestionstock.services.FournisseurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

	@Autowired
	FournisseurService service;

	@GetMapping
	public List<Fournisseur> getAllFournisseurs() {
		return service.getAllFournisseurs();
	}

	@GetMapping(value = "{id}")
	public Fournisseur getFournisseur(@PathVariable("id") long id) {
		return service.getFournisseur(id);
	}

	@PostMapping(value = "/creer")
	public ResponseEntity<?> createFournisseur(@Valid @RequestBody FournisseurForm fournisseurForm) {
		return service.createFournisseur(fournisseurForm);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> updateFournisseur(@PathVariable("id") long id, @RequestBody Fournisseur fournisseur) {
		return service.updateFournisseur(id, fournisseur);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> deleteFournisseur(@PathVariable("id") long id) {
		return service.deleteFournisseur(id);
	}
}

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

import fr.appgestionstock.messages.request.FournitureForm;
import fr.appgestionstock.models.Fourniture;
import fr.appgestionstock.models.FournitureCommande;
import fr.appgestionstock.services.FournitureService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fournitures")
public class FournitureController {

	@Autowired
	FournitureService service;

	@GetMapping
	public List<Fourniture> getAllFournitures() {
		return service.getAllFournitures();
	}

	@GetMapping(value = "/{id}")
	public Fourniture getFourniture(@PathVariable("id") long id) {
		return service.getFourniture(id);
	}

	@GetMapping(value = "/liste")
	public List<Fourniture> listeFournituresBDC(List<FournitureCommande> liste) {
		return service.listeFournituresBDC(liste);
	}

	@PostMapping(value = "/creer")
	public ResponseEntity<?> createFourniture(@Valid @RequestBody FournitureForm fournitureForm) {
		return service.createFourniture(fournitureForm);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Fourniture> updateFourniture(@PathVariable("id") long id,
			@RequestBody Fourniture fourniture) {
		return service.updateFourniture(id, fourniture);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFourniture(@PathVariable("id") long id) {
		return service.deleteFourniture(id);
	}
}

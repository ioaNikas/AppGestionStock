package fr.appgestionstock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.appgestionstock.messages.request.FournitureForm;
import fr.appgestionstock.messages.response.ResponseMessage;
import fr.appgestionstock.models.Fourniture;
import fr.appgestionstock.repository.FournitureRepository;

@Service
public class FournitureService {

	@Autowired
	FournitureRepository repo;

	// Afficher toutes les fournitures
	public List<Fourniture> getAllFournitures() {
		List<Fourniture> fournitures = new ArrayList<>();
		repo.findAll().forEach(fournitures::add);

		return fournitures;
	}

	// Afficher une fourniture en particulier
	public Fourniture getFourniture(long id) {
		Fourniture fourniture = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Aucune fourniture trouvée avec l'id : " + id));
		return fourniture;
	}

	// Ajouter une fourniture dans la BDD
	public ResponseEntity<?> createFourniture(FournitureForm requestFourniture) {
		Fourniture fourniture = new Fourniture(requestFourniture.getNom(), requestFourniture.getQuantite(),
				requestFourniture.getPrix(), requestFourniture.getFournisseur(), requestFourniture.getSeuilCritique());
		repo.save(fourniture);
		return new ResponseEntity<>(new ResponseMessage("Fourniture créée"), HttpStatus.OK);
	}

	// Modifier une fourniture existante
	public ResponseEntity<Fourniture> updateFourniture(@PathVariable("id") long id,
			@RequestBody Fourniture fourniture) {
		Optional<Fourniture> fournitureData = repo.findById(id);
		if (fournitureData.isPresent()) {
			Fourniture _fourniture = fournitureData.get();
			_fourniture.setQuantite(fourniture.getQuantite());
			_fourniture.setPrix(fourniture.getPrix());
			_fourniture.setFournisseur(fourniture.getFournisseur());
			_fourniture.setSeuilCritique(fourniture.getSeuilCritique());

			System.out.println("Nouvelles caractéristiques de la fourniture : " + _fourniture.toString());
			return new ResponseEntity<>(repo.save(_fourniture), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Supprimer définitivement une fourniture
	public ResponseEntity<String> deleteFourniture(@PathVariable("id") long id) {
		repo.deleteById(id);
		return new ResponseEntity<>("La fourniture avec l'id : " + id + " a été supprimée", HttpStatus.OK);
	}
}

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

import fr.appgestionstock.messages.request.FournisseurForm;
import fr.appgestionstock.messages.response.ResponseMessage;
import fr.appgestionstock.models.Fournisseur;
import fr.appgestionstock.repository.FournisseurRepository;

@Service
public class FournisseurService {

	@Autowired
	FournisseurRepository repo;

	public List<Fournisseur> getAllFournisseurs() {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		repo.findAll().forEach(fournisseurs::add);

		return fournisseurs;
	}

	public Fournisseur getFournisseur(long id) {
		Fournisseur fournisseur = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Aucun fournisseur trouvé avec l'id : " + id));

		System.out.println(fournisseur.toString());
		return fournisseur;
	}

	public ResponseEntity<?> createFournisseur(FournisseurForm requestFournisseur) {
		Fournisseur fournisseur = new Fournisseur(requestFournisseur.getRaisonSociale(),
				requestFournisseur.getAdresse(), requestFournisseur.getTel(), requestFournisseur.getEmail());
		repo.save(fournisseur);
		return new ResponseEntity<>(
				new ResponseMessage("Fournisseur ajouté à la base de donnée : " + fournisseur.toString()),
				HttpStatus.OK);
	}

	public ResponseEntity<?> updateFournisseur(@PathVariable("id") long id, @RequestBody Fournisseur fournisseur) {
		Optional<Fournisseur> fournisseurData = repo.findById(id);
		if (fournisseurData.isPresent()) {
			Fournisseur _fournisseur = fournisseurData.get();
			_fournisseur.setRaisonSociale(fournisseur.getRaisonSociale());
			_fournisseur.setAdresse(fournisseur.getAdresse());
			_fournisseur.setTel(fournisseur.getTel());
			_fournisseur.setEmail(fournisseur.getEmail());

			repo.save(_fournisseur);
			return new ResponseEntity<>(
					new ResponseMessage("Nouvelles propriété du fournisseur : " + _fournisseur.toString()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<String> deleteFournisseur(@PathVariable("id") long id) {
		repo.deleteById(id);
		return new ResponseEntity<>("Fournisseur avec l'id : " + id + " supprimé de la base de donnée", HttpStatus.OK);
	}
}

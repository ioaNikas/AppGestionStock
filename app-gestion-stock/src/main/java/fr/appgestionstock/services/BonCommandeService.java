package fr.appgestionstock.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import fr.appgestionstock.messages.request.BonCommandeForm;
import fr.appgestionstock.messages.response.ResponseMessage;
import fr.appgestionstock.models.BonCommande;
import fr.appgestionstock.models.UserEntity;
import fr.appgestionstock.repository.BonCommandeRepository;
import fr.appgestionstock.repository.UserRepository;

public class BonCommandeService {

	@Autowired
	BonCommandeRepository repo;

	@Autowired
	UserRepository userRepo;

	public List<BonCommande> getAllCommandes() {

		List<BonCommande> commandes = new ArrayList<>();

		repo.findAll().forEach(commandes::add);

		return commandes;
	}

	public ResponseEntity<?> postBonCommande(String email, BonCommandeForm bonCommandeRequest) {

		UserEntity site = (UserEntity) userRepo.findByEmail(email);

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		String dateCreation = dateFormat.format(date);

		BonCommande bonCommande = new BonCommande(site, dateCreation, bonCommandeRequest.getClient());

		repo.save(bonCommande);

		return new ResponseEntity<>(new ResponseMessage("Bon de commande créé : " + bonCommande.toString()),
				HttpStatus.OK);
	}
}

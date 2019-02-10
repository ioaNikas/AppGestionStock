package fr.appgestionstock.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.appgestionstock.models.BonCommande;
import fr.appgestionstock.models.UserEntity;
import fr.appgestionstock.repository.BonCommandeRepository;
import fr.appgestionstock.repository.UserRepository;
import fr.appgestionstock.shared.BonCommandeDto;
import fr.appgestionstock.shared.Utils;

@Service
public class BonCommandeService {

	@Autowired
	BonCommandeRepository repo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	Utils utils;

	public List<BonCommande> getAllCommandes() {

		List<BonCommande> commandes = new ArrayList<>();

		repo.findAll().forEach(commandes::add);

		return commandes;
	}

	public BonCommandeDto createBonCommande(BonCommandeDto bonCommandeDto, String userId) {

		// Trouve et stocke le user au format DTO
		UserEntity userDetails = (UserEntity) userRepo.findByUserId(userId);

		// Génère une instance de date, la formate puis la stocke au format String
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateCreation = dateFormat.format(date);

		// Génére un id publique (String) et la stocke
		String publicBonCommandeId = utils.generateRandomId(10);

		ModelMapper modelMapper = new ModelMapper();
		BonCommande bonCommande = modelMapper.map(bonCommandeDto, BonCommande.class);

		bonCommande.setBonCommandeId(publicBonCommandeId);
		bonCommande.setDateCreation(dateCreation);
		bonCommande.setUserDetails(userDetails);

		BonCommande storedBonCommande = repo.save(bonCommande);

		BonCommandeDto returnValue = modelMapper.map(storedBonCommande, BonCommandeDto.class);

		return returnValue;

	}
}

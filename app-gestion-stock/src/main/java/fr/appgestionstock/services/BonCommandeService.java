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
import fr.appgestionstock.models.Fourniture;
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
	FournitureService fournitureService;

	@Autowired
	Utils utils;

	public List<BonCommande> getCommandes(String userId) {

		List<BonCommande> returnValue = new ArrayList<>();

		UserEntity userEntity = userRepo.findByUserId(userId);
		if (userEntity == null)
			return returnValue;

		Iterable<BonCommande> commandes = repo.findAllByUserDetails(userEntity);
		for (BonCommande bonCommande : commandes) {
			returnValue.add(new ModelMapper().map(bonCommande, BonCommande.class));
		}

		return returnValue;
	}

	public BonCommande getCommande(String commandeId) {

		BonCommande returnValue = new BonCommande();
		BonCommande bonCommande = repo.findByBonCommandeId(commandeId);

		if (bonCommande != null) {
			returnValue = bonCommande;
		}

		return returnValue;
	}

	public BonCommande createBonCommande(BonCommandeDto bonCommandeDto, String userId) {

		// Trouve et stocke le user au format DTO
		UserEntity userDetails = (UserEntity) userRepo.findByUserId(userId);

		// Génère une instance de date, la formate puis la stocke au format String
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateCreation = dateFormat.format(date);

		// Génére un id publique (String) et la stocke
		String publicBonCommandeId = utils.generateRandomId(10);

		List<Fourniture> listeFourniture = fournitureService.listeFournituresBDC(bonCommandeDto.getListeFournitures());

		BonCommande bonCommande = new BonCommande(userDetails, publicBonCommandeId, listeFourniture, dateCreation,
				bonCommandeDto.getAuteur());

//		ModelMapper modelMapper = new ModelMapper();
//		BonCommande bonCommande = modelMapper.map(bonCommandeDto, BonCommande.class);

//		bonCommande.setBonCommandeId(publicBonCommandeId);
//		bonCommande.setDateCreation(dateCreation);
//		bonCommande.setUserDetails(userDetails);

		repo.save(bonCommande);

//		BonCommandeDto returnValue = modelMapper.map(storedBonCommande, BonCommandeDto.class);

		return bonCommande;

	}
}

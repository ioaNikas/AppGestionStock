package fr.appgestionstock.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.appgestionstock.messages.request.BonCommandeForm;
import fr.appgestionstock.messages.response.BonCommandeRest;
import fr.appgestionstock.models.BonCommande;
import fr.appgestionstock.services.BonCommandeService;
import fr.appgestionstock.shared.BonCommandeDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/commandes")
public class BonCommandeController {

	@Autowired
	BonCommandeService bonCommandeService;

	@PostMapping(value = "/creer/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public BonCommandeRest postBonCommande(@PathVariable("userId") String userId,
			@RequestBody BonCommandeForm bonCommandeRequest) {
		BonCommandeRest returnValue = new BonCommandeRest();
		ModelMapper modelMapper = new ModelMapper();

		BonCommandeDto bonCommandeDto = modelMapper.map(bonCommandeRequest, BonCommandeDto.class);

		BonCommande createdBonCommande = bonCommandeService.createBonCommande(bonCommandeDto, userId);
		returnValue = modelMapper.map(createdBonCommande, BonCommandeRest.class);

		return returnValue;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
			"application/hal+json" })
	public Resources<BonCommandeRest> getUserCommandes(@PathVariable("userId") String userId) {

		List<BonCommandeRest> bonCommandeRestModel = new ArrayList<>();

		List<BonCommande> bonCommande = bonCommandeService.getCommandes(userId);

		if (bonCommande != null && !bonCommande.isEmpty()) {

			Type listType = new TypeToken<List<BonCommandeRest>>() {
			}.getType();
			bonCommandeRestModel = new ModelMapper().map(bonCommande, listType);

			for (BonCommandeRest bonCommandeRest : bonCommandeRestModel) {
				Link commandeLink = linkTo(methodOn(BonCommandeController.class).getUserCommande(userId,
						bonCommandeRest.getBonCommandeId())).withSelfRel();
				bonCommandeRest.add(commandeLink);
				Link userLink = linkTo(methodOn(UserController.class).getUser(userId)).withRel("user");
				bonCommandeRest.add(userLink);
			}

		}

		return new Resources<>(bonCommandeRestModel);
	}

	@GetMapping(path = "/{userId}/commande/{commandeId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
	public Resource<BonCommandeRest> getUserCommande(@PathVariable("userId") String userId,
			@PathVariable("commandeId") String commandeId) {

		BonCommande bonCommande = bonCommandeService.getCommande(commandeId);

		Link bonCommandeLink = linkTo(methodOn(BonCommandeController.class).getUserCommande(userId, commandeId))
				.withSelfRel();
		Link userLink = linkTo(UserController.class).slash(userId).withRel("user");
		Link commandesLink = linkTo(methodOn(BonCommandeController.class).getUserCommandes(userId))
				.withRel("commandes");

		BonCommandeRest bonCommandeRestModel = new ModelMapper().map(bonCommande, BonCommandeRest.class);

		bonCommandeRestModel.add(bonCommandeLink);
		bonCommandeRestModel.add(userLink);
		bonCommandeRestModel.add(commandesLink);

		return new Resource<>(bonCommandeRestModel);
	}
}

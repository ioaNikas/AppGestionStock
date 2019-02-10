package fr.appgestionstock.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.appgestionstock.messages.request.BonCommandeForm;
import fr.appgestionstock.messages.response.BonCommandeRest;
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

		BonCommandeDto createdBonCommande = bonCommandeService.createBonCommande(bonCommandeDto, userId);
		returnValue = modelMapper.map(createdBonCommande, BonCommandeRest.class);

		return returnValue;
	}
}

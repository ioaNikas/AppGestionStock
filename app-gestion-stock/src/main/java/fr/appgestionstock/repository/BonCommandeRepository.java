package fr.appgestionstock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.appgestionstock.models.BonCommande;
import fr.appgestionstock.models.UserEntity;

@Repository
public interface BonCommandeRepository extends CrudRepository<BonCommande, Long> {

	Iterable<BonCommande> findAllByUserDetails(UserEntity userEntity);

	BonCommande findByBonCommandeId(String commandeId);

}

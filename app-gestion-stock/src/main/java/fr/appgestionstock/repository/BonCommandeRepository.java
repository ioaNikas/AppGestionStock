package fr.appgestionstock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.appgestionstock.models.BonCommande;

@Repository
public interface BonCommandeRepository extends CrudRepository<BonCommande, Long> {

}

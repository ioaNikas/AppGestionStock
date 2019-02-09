package fr.appgestionstock.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.appgestionstock.models.Fournisseur;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
	Optional<Fournisseur> findByRaisonSociale(String raisonSociale);
}

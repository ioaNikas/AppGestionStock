package fr.appgestionstock.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.appgestionstock.models.Fourniture;

public interface FournitureRepository extends CrudRepository<Fourniture, Long> {
	Optional<Fourniture> findByNom(String nom);
}

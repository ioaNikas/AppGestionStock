package fr.appgestionstock.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.appgestionstock.models.Fourniture;

@Repository
public interface FournitureRepository extends CrudRepository<Fourniture, Long> {
	Optional<Fourniture> findByNom(String nom);
}

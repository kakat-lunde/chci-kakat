package eu.lundegaard.repository;

import eu.lundegaard.model.Toilet;
import org.springframework.data.repository.CrudRepository;

public interface ToiletRepository extends CrudRepository<Toilet, Long> {
}

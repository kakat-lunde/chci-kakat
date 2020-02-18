package eu.lundegaard.repository;

import eu.lundegaard.model.Toilet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToiletRepository extends CrudRepository<Toilet, Long> {
}

package eu.lundegaard.repository;

import eu.lundegaard.model.PoopingSession;
import eu.lundegaard.model.Toilet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoopingSessionRepository extends CrudRepository<PoopingSession, Long> {

    Iterable<PoopingSession> findAllByEndTimeIsNull();

    Optional<PoopingSession> findByToiletAndEndTimeIsNull(Toilet toilet);
}

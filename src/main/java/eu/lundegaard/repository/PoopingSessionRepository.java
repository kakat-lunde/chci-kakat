package eu.lundegaard.repository;

import eu.lundegaard.model.PoopingSession;
import eu.lundegaard.model.Toilet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoopingSessionRepository extends CrudRepository<PoopingSession, Long> {

    Optional<PoopingSession> findByToiletAndEndTimeIsNull(Toilet toilet);

//    @Query("SELECT poop FROM PoopingSession ORDER BY FUNCTION('DATEDIFF', poop.endTime, poop.startTime) ASC")
//    Iterable<PoopingSession> findTop10ByDuration();
}

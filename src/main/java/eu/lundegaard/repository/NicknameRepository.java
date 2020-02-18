package eu.lundegaard.repository;

import eu.lundegaard.model.Nickname;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NicknameRepository extends CrudRepository<Nickname, Long> {
}

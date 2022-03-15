package hobby.ccgame.repository;

import hobby.ccgame.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CCGameRepository extends MongoRepository<Card, String> {
}

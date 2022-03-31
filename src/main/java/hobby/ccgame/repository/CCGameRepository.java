package hobby.ccgame.repository;

import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CCGameRepository extends MongoRepository<Card, String>, QueryByExampleExecutor<Card> {
}

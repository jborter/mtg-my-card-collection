package mtg.myCardCollection;

import mtg.myCardCollection.domain.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jbo on 21.06.2016.
 */
@Repository
public interface CardCollectionRepository extends MongoRepository<Card, String> {
}

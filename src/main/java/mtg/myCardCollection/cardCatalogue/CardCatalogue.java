package mtg.myCardCollection.cardCatalogue;

import mtg.myCardCollection.domain.*;
import mtg.myCardCollection.domain.Edition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jbo on 21.06.2016.
 */
@Service
public class CardCatalogue {

    @Value("${mtg.cardCatalogueHost}")
    private String cardCatalogueHost;

    public mtg.myCardCollection.domain.Card getCard(String cardId) {

        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(cardCatalogueHost + "/" + cardId, Card.class);

        mtg.myCardCollection.domain.Card collectedCard = new mtg.myCardCollection.domain.Card();
        collectedCard.setId(card.getId());
        collectedCard.setName(card.getName());
        collectedCard.setColors(card.getColors());
        collectedCard.setTypes(card.getTypes());

        return collectedCard;
    }
}

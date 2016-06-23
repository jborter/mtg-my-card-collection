package mtg.myCardCollection.cardCatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jbo on 21.06.2016.
 */
@Service
public class CardCatalogue {

    private static final String CARD_CATALOGUE_SERVICE_ID = "mtg-card-catalogue";

    @Autowired
    private RestTemplate restTemplate;

    public mtg.myCardCollection.domain.Card getCard(String cardId, String editionId) {
        Card card = restTemplate.getForObject("http://" + CARD_CATALOGUE_SERVICE_ID + "/mtg-card-catalogue/cards/" + cardId, Card.class);

        mtg.myCardCollection.domain.Card collectedCard = new mtg.myCardCollection.domain.Card();
        collectedCard.setId(card.getId());
        collectedCard.setName(card.getName());
        collectedCard.setColors(card.getColors());
        collectedCard.setTypes(card.getTypes());

        collectedCard.addEdition(getCardEdition(card, editionId));

        return collectedCard;
    }

    private mtg.myCardCollection.domain.Edition getCardEdition(Card card, String editionId) {
        Edition edition = Stream.of(card.getEditions()).filter(e -> e.getSet_id().equals(editionId)).findFirst().get();

        mtg.myCardCollection.domain.Edition collectedCardEdition = new mtg.myCardCollection.domain.Edition();
        collectedCardEdition.setId(edition.getSet_id());
        collectedCardEdition.setName(edition.getSet());
        return collectedCardEdition;
    }

    public mtg.myCardCollection.domain.Edition getCardEdition(String cardId, String editionId) {
        Card card = restTemplate.getForObject("http://" + CARD_CATALOGUE_SERVICE_ID + "/mtg-card-catalogue/cards/" + cardId, Card.class);
        return getCardEdition(card, editionId);
    }
}

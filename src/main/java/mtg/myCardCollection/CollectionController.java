package mtg.myCardCollection;

import mtg.myCardCollection.cardCatalogue.CardCatalogue;
import mtg.myCardCollection.domain.Card;
import mtg.myCardCollection.uiModel.CardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;


/**
 * Created by jbo on 20.06.2016.
 */
@Controller
public class CollectionController {

    private static final String COLLECTION_TEMPLATE = "collection";

    @Autowired
    private CardCatalogue cardCatalogue;

    @Autowired
    private CardCollectionRepository cardCollectionRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getCards(Model model) {
        model.addAttribute("card", new CardModel());
        model.addAttribute("myCollection", cardCollectionRepository.findAll());
        return COLLECTION_TEMPLATE;
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String addCardToCollection(@ModelAttribute CardModel card, Model model) {
        Card collectedCard = loadCardFromCollectionOrCatalogue(card.getCardId());
        collectedCard.setNumberOfCards(card.getEditionId(), card.getNumberOfCards());
        cardCollectionRepository.save(Arrays.asList(collectedCard));
        model.addAttribute("card", new CardModel());
        model.addAttribute("myCollection", cardCollectionRepository.findAll());
        return COLLECTION_TEMPLATE;
    }

    private Card loadCardFromCollectionOrCatalogue (String cardId) {
        Card collectedCard = cardCollectionRepository.findOne(cardId);
        if (collectedCard != null) {
            return collectedCard;
        } else {
            return cardCatalogue.getCard(cardId);
        }
    }
}

package mtg.myCardCollection.domain;

/**
 * Created by jbo on 21.06.2016.
 */
public class Edition {

    Edition() {
    }

    private String id;
    private int numberOfCards;
    private Price[] prices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
}

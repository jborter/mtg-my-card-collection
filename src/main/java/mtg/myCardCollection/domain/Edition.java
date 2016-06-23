package mtg.myCardCollection.domain;

/**
 * Created by jbo on 21.06.2016.
 */
public class Edition {

    public Edition() {
    }

    private String id;
    private String name;
    private int numberOfCards;
    private Price price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Price getPrice() {
        return price == null ? new Price() : price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

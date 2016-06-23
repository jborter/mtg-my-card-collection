package mtg.myCardCollection.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jbo on 21.06.2016.
 */
public class Card {

    @Id
    private String id;

    private String name;
    private String[] types;
    private String[] colors;
    private Edition[] editions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public Edition[] getEditions() {
        return editions == null ? new Edition[0] : editions;
    }

    public void addEdition(Edition edition) {
        List<Edition> editions = new ArrayList<>(Arrays.asList(getEditions()));
        editions.add(edition);
        this.editions = editions.toArray(new Edition[0]);
    }

    public boolean hasEdition(String editionId) {
        return Stream
                .of(getEditions())
                .filter(e -> e.getId().equals(editionId))
                .findFirst()
                .isPresent();
    }

    public void setNumberOfCards(String editionId, int numberOfCards) {

        Edition edition = Stream
                .of(getEditions())
                .filter(e -> e.getId().equals(editionId))
                .findFirst()
                .get();

        edition.setNumberOfCards(numberOfCards);
    }
}

package pl.dixu.server;

import pl.dixu.server.card.Card;
import pl.dixu.server.card.CardType;

import java.util.Collection;
import java.util.stream.IntStream;

public class CardFactory {

    public Collection<Card> getCards() {
        return IntStream.range(0, 40)
                .boxed()
                .map(num -> new Card("Minion " + num, CardType.MINION))
                .toList();
    }

    public Collection<Card> getLocations() {
        return IntStream.range(0, 20)
                .boxed()
                .map(num -> new Card("Location " + num, CardType.LOCATION))
                .toList();
    }


}

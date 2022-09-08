package pl.dixu.server;

import pl.dixu.server.card.Card;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class CardFactory {

    public Collection<Card> getCards() {
        return IntStream.range(0, 40)
                .boxed()
                .map(num -> new Card("Monster " + num))
                .toList();
    }

    public Collection<Card> getLocations() {
        return IntStream.range(0, 20)
                .boxed()
                .map(num -> new Card("Location " + num))
                .toList();
    }


}

package pl.dixu.server.player;

import pl.dixu.server.bus.EventBus;
import pl.dixu.server.card.Card;
import pl.dixu.server.card.DrawData;
import pl.dixu.server.card.DrawEvent;

import java.util.*;
import java.util.stream.IntStream;

public class Player {
    private int id;
    private Queue<Card> drawPile;
    private Queue<Card> discardPile = new LinkedList<>();
    private List<Card> hand = new ArrayList<>();
    private EventBus bus;

    public Player(Collection<Card> drawPile, int id, EventBus bus) {
        this.id = id;
        this.bus = bus;
        this.drawPile = new LinkedList<>(drawPile);
    }

    public void draw(int count) {
        IntStream.range(0,count)
                .forEach(i -> draw());
    }

    private void draw() {
        Card card = drawPile.poll();
        if (card == null) {
            reshuffle();
        }
        bus.dispatch(new DrawEvent(new DrawData(card.getId(),id)));
    }

    private void reshuffle() {
        //todo implement me
    }
}

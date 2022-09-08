package pl.dixu.server.player;

import pl.dixu.server.card.Card;

import java.util.*;

public class Player {
    private Queue<Card> drawPile;
    private Queue<Card> discardPile = new LinkedList<>();
    private List<Card> hand = new ArrayList<>();

    public Player(Collection<Card> drawPile) {
        drawPile = new LinkedList<>(drawPile);
    }

}

package pl.dixu.server.area;

import pl.dixu.server.card.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Area {
    private Card location;
    private Map<Integer, List<Card>> minions = new HashMap<>();
    private List<Card> areaActions = new ArrayList<>();

    public Area(Card location, int playerCount) {
        this.location = location;
        IntStream.range(0, playerCount)
                .forEach(playerId -> minions.put(playerId, new ArrayList<>()));
    }



}

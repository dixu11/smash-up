package pl.dixu.server;

import pl.dixu.server.area.Area;
import pl.dixu.server.player.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Server {

    public static final int DEFAULT_PLAYERS_COUNT = 2;
    private Presenter presenter;
    private CardFactory cardFactory = new CardFactory();

    private Queue<Player> players;
    private List<Area> areas;

    public Server(Presenter presenter) {
        this.presenter = presenter;
    }

    public void onGameStart() {
        //przygotować talie graczy
        players = createPlayers(DEFAULT_PLAYERS_COUNT);
        //przygotować talie lokacji
        areas = createAreas(DEFAULT_PLAYERS_COUNT);
        //ustawić startowego gracza
        //dociągnąć 3 lokacje
        //odpalić start tury dla gracza 1
    }

    private Queue<Player> createPlayers(int count) {
        return IntStream.range(0, count)
                .boxed()
                .map(i -> new Player(cardFactory.getCards()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private List<Area> createAreas(int count) {
        return cardFactory.getLocations()
                .stream()
                .map(card -> new Area(card, DEFAULT_PLAYERS_COUNT))
                .toList();
    }


}

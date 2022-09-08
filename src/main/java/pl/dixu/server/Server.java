package pl.dixu.server;

import pl.dixu.server.area.Area;
import pl.dixu.server.card.Card;
import pl.dixu.server.player.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Server {

    public static final int DEFAULT_PLAYERS_COUNT = 2;
    public static final int DEFAULT_STARTING_AREAS_COUNT = 3;
    private Presenter presenter;
    private CardFactory cardFactory = new CardFactory();

    private Queue<Player> players;
    private Queue<Card> areasDeck;
    private List<Area> activeAreas = new ArrayList<>();

    public Server(Presenter presenter) {
        this.presenter = presenter;
    }


    public void play() {
        onGameStart();
        presenter.startGame();
        presenter.initAreas(activeAreas);
    }

    private void onGameStart() {
        players = createPlayers(DEFAULT_PLAYERS_COUNT);
        areasDeck = createAreasDeck();
        addStartingAreas(DEFAULT_STARTING_AREAS_COUNT);
    }




    private Queue<Player> createPlayers(int count) {
        return IntStream.range(0, count)
                .boxed()
                .map(i -> new Player(cardFactory.getCards()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private Queue<Card> createAreasDeck() {
        return new LinkedList<>(cardFactory.getLocations());
    }

    private void addStartingAreas(int count){
        IntStream.range(0,count)
                .forEach(i -> addArea());
    }

  private void addArea(){
        activeAreas.add( new Area( areasDeck.remove(), DEFAULT_PLAYERS_COUNT));
  }

    public Player getActualPlayer() {
        return players.element();
    }


}

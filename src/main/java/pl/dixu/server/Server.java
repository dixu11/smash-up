package pl.dixu.server;

import pl.dixu.server.area.Area;
import pl.dixu.server.bus.EventBus;
import pl.dixu.server.bus.SyncEventBus;
import pl.dixu.server.card.Card;
import pl.dixu.server.player.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//on setup, on turn (macro)
public class Server {


    private Presenter presenter;
    private CardFactory cardFactory = new CardFactory();

    private Queue<Player> players;
    private Queue<Card> areasDeck;
    private List<Area> activeAreas = new ArrayList<>();
    private EventBus eventBus = new SyncEventBus();

    public Server(Presenter presenter) {
        this.presenter = presenter;
        presenter.initEventBuss(eventBus);
    }


    public void play() {
        onGameStart();
        presenter.startGame();
        presenter.initAreas(activeAreas);
        playTurn();
    }

    private void onGameStart() {
        players = createPlayers(GameSetup.DEFAULT_PLAYERS_COUNT);
        areasDeck = createAreasDeck();
        addStartingAreas(GameSetup.DEFAULT_STARTING_AREAS_COUNT);
    }

    private void playTurn(){
        Player actualPlayer = players.remove();
        players.add(actualPlayer);
        playTurn(actualPlayer);
    }

    private void playTurn(Player player) {
        //setCurrentPlayer
        player.draw(5);
        //draw 5 cards

        //do nothing, let Presenter trigger actions
    }

    private Queue<Player> createPlayers(int count) {
        return IntStream.range(0, count)
                .boxed()
                .map(i -> new Player(cardFactory.getCards(), i, eventBus))
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
        activeAreas.add( new Area( areasDeck.remove(), GameSetup.DEFAULT_PLAYERS_COUNT));
  }

    public Player getActualPlayer() {
        return players.element();
    }


}

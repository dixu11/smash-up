package pl.dixu.client;

import pl.dixu.server.Point;
import pl.dixu.server.Presenter;
import pl.dixu.server.TableLayout;
import pl.dixu.server.area.Area;
import pl.dixu.server.bus.EventBus;
import pl.dixu.server.card.DeckType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingPresenter implements Presenter {

    private final List<AreaView> areas = new ArrayList<>();
    private final DeckView locationDeck = ImageManager.initDeckCover(DeckType.LOCATION);
    private final DeckView player1Deck = ImageManager.initDeckCover(DeckType.PLAYER);
    private final DeckView player2Deck = ImageManager.initDeckCover(DeckType.PLAYER);
    private final HandView playerHand = new HandView();
    private EventBus eventBus;

    @Override
    public void startGame() {

    }

    @Override
    public void initEventBuss(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.register(playerHand);
    }

    @Override
    public void initAreas(List<Area> activeAreas) {
        for (int i = 0; i < activeAreas.size(); i++) {
            areas.add(new AreaView(activeAreas.get(i),i));
        }
    }

    public void tick() {

    }

    public void render(Graphics g){
       areas.forEach(areaView -> areaView.render(g));
        TableLayout layout = TableLayout.getInstance();
        Point point = layout.getLocationDrawDeckPosition();
        g.translate(point.x, point.y); //todo refactor
        locationDeck.render(g);
        g.translate(-point.x, -point.y);
        point = layout.getPlayerDrawPosition(0);
        g.translate(point.x, point.y);
        player1Deck.render(g);
        g.translate(-point.x, -point.y);
        playerHand.render(g);
    }

    public void click(Point point) {
        playerHand.reactToClick(point);
    }
}

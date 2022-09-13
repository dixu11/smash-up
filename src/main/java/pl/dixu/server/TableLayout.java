package pl.dixu.server;

import pl.dixu.client.Bound;
import pl.dixu.server.player.Player;

public class TableLayout {

    private static final TableLayout instance = new TableLayout();

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    private static final double CARD_SIZE_MODIFIER = 0.17;
    public static final int CARD_HEIGHT = (int) (1024*CARD_SIZE_MODIFIER);
    public static final int CARD_WIDTH = (int) (734*CARD_SIZE_MODIFIER);

    private static final int LOCATION_ROW_X = (int) (WIDTH * 0.2);
    private static final int LOCATION_ROW_Y = (int) (HEIGHT * 0.35);
    private static final int LOCATION_ROW_GAP = (int) (WIDTH * 0.15);
    private static final int YOUR_DECK_X = (int) (WIDTH * 0.2);
    private static final int YOUR_DECK_Y = (int) (HEIGHT * 0.8);


    private TableLayout() {

    }

    public static TableLayout getInstance() {
        return instance;
    }

    public Point getLocationPosition(int locationIndex) {
        return new Point(LOCATION_ROW_X + locationIndex * LOCATION_ROW_GAP + locationIndex * CARD_HEIGHT, LOCATION_ROW_Y);
    }

    public Point getLocationDrawDeckPosition(){
        return new Point(LOCATION_ROW_X - CARD_WIDTH - LOCATION_ROW_GAP/2, LOCATION_ROW_Y );
    }

    public Point getLocationDiscardPosition() {
        return null;
        //todo
    }

    public Point getPlayerDrawPosition(int playerIndex) {
        if (playerIndex == 0) {
            return getYourPlayerDrawPosition();
        }
        return null; //todo other players
    }

    private Point getYourPlayerDrawPosition() {
        return new Point(YOUR_DECK_X,YOUR_DECK_Y);
    }

    public Point getPlayerHandPosition() {
        return new Point(YOUR_DECK_X+LOCATION_ROW_GAP, YOUR_DECK_Y);
    }

    public Point getPlayerHandCardPosition(int cardIndex){
        Point playerHandPosition = getPlayerHandPosition();
        playerHandPosition.x= playerHandPosition.x + cardIndex *(LOCATION_ROW_GAP/2);
        return playerHandPosition;
    }

    public  Bound convertToBound(Point point) {
        return new Bound(point, CARD_WIDTH, CARD_HEIGHT);
    }
}

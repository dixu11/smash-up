package pl.dixu.server;

import pl.dixu.server.player.Player;

public class TableLayout {

    private static final TableLayout instance = new TableLayout();

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int CARD_HEIGHT = 256; //todo resize refactor - width /7?
    public static final int CARD_WIDTH = 183 ;

    private static final int LOCATION_ROW_X = (int) (WIDTH * 0.2);
    private static final int LOCATION_ROW_Y = (int) (HEIGHT * 0.4);
    private static final int LOCATION_ROW_GAP = (int) (WIDTH * 0.1);
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
        return new Point(LOCATION_ROW_X - CARD_WIDTH - LOCATION_ROW_GAP/2, (int) (LOCATION_ROW_Y - HEIGHT*0.03));
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

}

package pl.dixu.server;

public class TableLayout {

    private static final TableLayout instance = new TableLayout();

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int CARD_HEIGHT = 256; //todo resize refactor - width /7?
    public static final int CARD_WIDTH = 183;

    private static final int LOCATION_ROW_X = (int) (WIDTH * 0.2);
    private static final int LOCATION_ROW_Y = (int) (HEIGHT * 0.4);
    private static final int LOCATION_ROW_GAP = (int) (WIDTH * 0.1);


    private TableLayout() {

    }

    public static TableLayout getInstance() {
        return instance;
    }

    public Point getLocationPosition(int locationIndex) {
        return new Point(LOCATION_ROW_X + locationIndex * LOCATION_ROW_GAP + locationIndex * CARD_HEIGHT, LOCATION_ROW_Y);
    }

}

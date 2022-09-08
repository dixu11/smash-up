package pl.dixu.client;

import pl.dixu.server.Point;
import pl.dixu.server.TableLayout;
import pl.dixu.server.area.Area;

import java.awt.*;


public class AreaView {

    private Area area;
    private int index;

    public AreaView(Area area, int index) {
        this.area = area;
        this.index = index;
    }

    public void render(Graphics g){
        CardView cardView = CardViewFactory.initCardView(area.getLocationCard());
        TableLayout layout = TableLayout.getInstance();
        Point point = layout.getLocationPosition(index);
        g.translate(point.x, point.y);
        cardView.render(g);
        g.translate(-point.x, -point.y);
    }
}

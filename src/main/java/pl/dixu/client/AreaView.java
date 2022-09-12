package pl.dixu.client;

import pl.dixu.server.Point;
import pl.dixu.server.TableLayout;
import pl.dixu.server.area.Area;

import java.awt.*;


public class AreaView {

    private Area area;
    private int index;
    private LocationView locationView = new LocationView();

    public AreaView(Area area, int index) {
        this.area = area;
        this.index = index;
    }

    public void render(Graphics g){
        locationView.updateCard(area.getLocationCard());
        TableLayout layout = TableLayout.getInstance();
        Point point = layout.getLocationPosition(index);
        g.translate(point.x, point.y);
        locationView.render(g);
        g.translate(-point.x, -point.y);
    }
}

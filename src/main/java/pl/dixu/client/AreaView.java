package pl.dixu.client;

import pl.dixu.server.area.Area;

import java.awt.*;

public class AreaView {

    private Area area;

    public AreaView(Area area) {
        this.area = area;
    }

    public void render(Graphics g){
        CardView cardView = CardViewFactory.initCardView(area.getLocationCard());
        cardView.render(g);
    }
}

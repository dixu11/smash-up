package pl.dixu.client;

import pl.dixu.server.Point;
import pl.dixu.server.TableLayout;
import pl.dixu.server.bus.Event;
import pl.dixu.server.bus.Subscribable;
import pl.dixu.server.card.DrawData;
import pl.dixu.server.card.DrawEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandView implements Subscribable {

    private List<HandCardView> handCardViews = new ArrayList<>();
    private HandCardView selected = null;

    public void render(Graphics graphics) {
        for (int i = 0; i < handCardViews.size(); i++) {
            HandCardView card = handCardViews.get(i);
            Point point = TableLayout.getInstance().getPlayerHandCardPosition(i);
            graphics.translate(point.x, point.y);
            card.render(graphics);
            graphics.translate(-point.x, -point.y);
        }
    }

    @Override
    public void handle(Event<?> event) {
        DrawData data = (DrawData) event.getData();
        HandCardView handCardView = new HandCardView(data.cardId());
        handCardViews.add(handCardView);
    }

    @Override
    public Set<Class<?>> supports() {
        return Set.of(DrawEvent.class);
    }

    public void reactToClick(Point point) {
        for (int i = 0; i < handCardViews.size(); i++) {
            Point cardPosition = TableLayout.getInstance().getPlayerHandCardPosition(i);
            Bound bound = TableLayout.getInstance().convertToBound(cardPosition);
            if (bound.isInBound(point)) {
                if (selected != null) {
                    selected.setShine(false);
                }
                selected = handCardViews.get(i);
                selected.setShine(true);
            }
        }
    }

}

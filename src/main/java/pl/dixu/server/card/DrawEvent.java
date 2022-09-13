package pl.dixu.server.card;

import pl.dixu.server.bus.Event;

public class DrawEvent implements Event<DrawData> {

    private DrawData drawData;

    public DrawEvent(DrawData drawData) {
        this.drawData = drawData;
    }

    @Override
    public DrawData getData() {
        return drawData;
    }
}

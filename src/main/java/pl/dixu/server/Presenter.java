package pl.dixu.server;

import pl.dixu.server.area.Area;
import pl.dixu.server.bus.EventBus;

import java.util.List;

public interface Presenter {


    void startGame();

    void initAreas(List<Area> activeAreas);

    void initEventBuss(EventBus eventBus);
}

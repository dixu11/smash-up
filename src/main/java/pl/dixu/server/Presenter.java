package pl.dixu.server;

import pl.dixu.server.area.Area;

import java.util.List;

public interface Presenter {


    void startGame();

    void initAreas(List<Area> activeAreas);
}

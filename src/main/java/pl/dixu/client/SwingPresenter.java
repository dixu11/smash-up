package pl.dixu.client;

import pl.dixu.server.Presenter;
import pl.dixu.server.area.Area;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingPresenter implements Presenter {

    private final List<AreaView> areas = new ArrayList<>();

    @Override
    public void startGame() {

    }

    @Override
    public void initAreas(List<Area> activeAreas) {
        for (int i = 0; i < activeAreas.size(); i++) {
            areas.add(new AreaView(activeAreas.get(i),i));
        }
    }

    public void tick() {

    }

    public void render(Graphics g){
       areas.forEach(areaView -> areaView.render(g));
    }
}

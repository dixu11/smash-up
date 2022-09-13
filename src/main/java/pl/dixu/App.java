package pl.dixu;

import pl.dixu.client.Display;
import pl.dixu.client.GameEngine;
import pl.dixu.client.SwingPresenter;
import pl.dixu.server.Server;

public class App {
    public static void main(String[] args) {
        //configuration
        Display.LOCATION_X_POSITION = Display.MONITOR2; //if you don't see game, change to MONITOR1

        Display display = new Display("Smash Up");
        SwingPresenter client = new SwingPresenter();
        GameEngine gameEngine = new GameEngine(display,client);
        Server server = new Server(client);
        gameEngine.start();
        server.play();
    }
}

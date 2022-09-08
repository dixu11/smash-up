package pl.dixu;

import pl.dixu.client.SwingPresenter;
import pl.dixu.server.Server;

public class App {
    public static void main(String[] args) {
        SwingPresenter client = new SwingPresenter();
        Server server = new Server(client);
        server.onGameStart();
    }
}

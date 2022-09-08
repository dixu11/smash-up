package pl.dixu.client;

import pl.dixu.server.TableLayout;

import java.awt.*;

public class DeckView {

    private Image image;

    public DeckView(Image image) {
        this.image = image;
    }

    public void render(Graphics g) {
        g.drawImage(image, 0, 0, TableLayout.CARD_WIDTH,TableLayout.CARD_HEIGHT, null);
    }
}

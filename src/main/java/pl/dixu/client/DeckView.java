package pl.dixu.client;

import pl.dixu.server.TableLayout;

import java.awt.*;

public class DeckView {

    private Image image;
    private boolean tap;

    public DeckView(Image image, boolean tap) {
        this.image = image;
        this.tap = tap;
    }

    public void render(Graphics g) {
        if (tap) {
            g.drawImage(image, 0, 0, TableLayout.CARD_HEIGHT, TableLayout.CARD_WIDTH, null);
        } else {
            g.drawImage(image, 0, 0, TableLayout.CARD_WIDTH,TableLayout.CARD_HEIGHT, null);
        }
    }
}

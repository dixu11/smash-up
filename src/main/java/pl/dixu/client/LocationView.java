package pl.dixu.client;

import pl.dixu.server.TableLayout;
import pl.dixu.server.card.Card;

import java.awt.*;

public class LocationView {
    private Card card = null;
    private Image image = null;

    public LocationView() {

    }

    public void render(Graphics g) {
        if (card == null || image == null) {
            return;
        }
        g.drawImage(image, 0, 0, TableLayout.CARD_HEIGHT, TableLayout.CARD_WIDTH, null);
    }

    public void updateCard(Card card) {
        this.card = card;
        image = ImageManager.getImage(card);
    }

}

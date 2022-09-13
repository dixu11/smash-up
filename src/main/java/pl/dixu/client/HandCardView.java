package pl.dixu.client;

import pl.dixu.server.TableLayout;
import pl.dixu.server.card.Card;

import java.awt.*;

public class HandCardView {

    private Image image;

    public HandCardView(String cardId) {
        image = ImageManager.getImage(cardId);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, 0, 0, TableLayout.CARD_WIDTH, TableLayout.CARD_HEIGHT, null);
    }
}

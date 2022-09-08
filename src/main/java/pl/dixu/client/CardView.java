package pl.dixu.client;

import pl.dixu.server.TableLayout;
import pl.dixu.server.card.Card;

import java.awt.*;

public class CardView {
    private Card card;
    private Image image;

    public CardView(Card card, Image image) {
        this.card = card;
        this.image = image;
    }

    public void render(Graphics g) {
        //card is rotated 90^
        g.drawImage(image, 0, 0, TableLayout.CARD_HEIGHT,TableLayout.CARD_WIDTH, null);
    }

}

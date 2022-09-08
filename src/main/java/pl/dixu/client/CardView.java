package pl.dixu.client;

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
        g.drawImage(image, 0, 0, null);
    }

}

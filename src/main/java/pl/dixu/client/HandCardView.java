package pl.dixu.client;

import pl.dixu.server.TableLayout;

import java.awt.*;

public class HandCardView {

    private Image image;
    private boolean shine;
    private static final int BORDER_THICKNESS = 3;

    public HandCardView(String cardId) {
        image = ImageManager.getImage(cardId);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, 0, 0, TableLayout.CARD_WIDTH, TableLayout.CARD_HEIGHT, null);
        if (shine) {
            graphics.setColor(Color.GREEN);
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.setStroke(new BasicStroke(BORDER_THICKNESS));
            graphics.drawRect(-BORDER_THICKNESS,-BORDER_THICKNESS,TableLayout.CARD_WIDTH+BORDER_THICKNESS*2,TableLayout.CARD_HEIGHT+BORDER_THICKNESS*2);
        }
    }

    public void setShine(boolean shine) {
        this.shine = shine;
    }
}

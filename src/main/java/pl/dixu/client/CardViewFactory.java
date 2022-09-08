package pl.dixu.client;

import pl.dixu.server.card.Card;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CardViewFactory {


    public static CardView initCardView(Card card) {
        String cardFileName = switch (card.getType()) {
            case LOCATION -> "location";
            case ACTION -> "action";
            case MINION -> "minion";
        };


        File file = new File(String.format("src/main/resources/%s.png",cardFileName));
        try {
            return new CardView(card,ImageIO.read(file));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }


    }


}

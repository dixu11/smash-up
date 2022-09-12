package pl.dixu.client;

import pl.dixu.server.card.Card;
import pl.dixu.server.card.DeckType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageManager {

    public static Image getImage(Card card) {
        String cardFileName = switch (card.getType()) {
            case LOCATION -> "location";
            case ACTION -> "action";
            case MINION -> "minion";
        };
        return readImage(cardFileName+ card.getIndex());
    }

    public static DeckView initDeckCover(DeckType deckType){
        String cardFileName = switch (deckType) {
            case LOCATION -> "locationCover";
            case PLAYER -> "playerCover";
        };
        return new DeckView(readImage(cardFileName));
    }


    private static Image readImage(String fileName) {
        File file = new File(String.format("src/main/resources/%s.jpg",fileName));
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}

package pl.dixu.client;

import pl.dixu.server.card.DeckType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageManager {

    public static Image getImage(String cardId) {
        return readImage(cardId);
    }

    public static DeckView initDeckCover(DeckType deckType){
        String cardFileName = switch (deckType) {
            case LOCATION ->  "locationCover";
            case PLAYER -> "playerCover";
        };
        return new DeckView(readImage(cardFileName), deckType.isTap());
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

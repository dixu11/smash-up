package pl.dixu.server.card;

public class Card {
    private String name;
    private CardType type;
    private String id;

    public Card(String name, CardType type, String id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public CardType getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
